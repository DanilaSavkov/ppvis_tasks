package implementation;

import abstraction.AbstractGroup;
import abstraction.AbstractStudent;
import abstraction.AbstractUniversityDB;
import exception.GroupAlreadyExistsException;
import exception.GroupNotFoundException;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniversityDB implements AbstractUniversityDB {
    private final List<AbstractGroup> groups;

    public UniversityDB() {
        groups = new ArrayList<>();
    }

    @Override
    public List<AbstractStudent> getStudentsByGroup(AbstractGroup group) throws GroupNotFoundException {
        if (!groups.contains(group)) throw new GroupNotFoundException();
        else return group.getStudents();
    }

    @Override
    public Map<AbstractStudent, AbstractGroup> searchStudentsBySurname(String surname) throws StudentNotFoundException {
        Map<AbstractStudent, AbstractGroup> result = new HashMap<>();
        for (AbstractGroup group : groups) {
            try {
                result.put(group.getStudentBySurname(surname), group);
            } catch (StudentNotFoundException ignored) {
            }
        }
        if (result.isEmpty()) throw new StudentNotFoundException();
        else return result;
    }

    @Override
    public synchronized void addGroup(AbstractGroup group) throws GroupAlreadyExistsException {
        if (groups.contains(group)) throw new GroupAlreadyExistsException();
        else groups.add(group);
    }

    @Override
    public synchronized void removeGroup(AbstractGroup group) throws GroupNotFoundException {
        if (!groups.contains(group)) throw new GroupNotFoundException();
        else groups.remove(group);
    }

    @Override
    public List<AbstractStudent> getStudentsByCourse(Integer course) throws StudentNotFoundException {
        List<AbstractStudent> result = new ArrayList<>();
        for (AbstractGroup group : groups) {
            if (course.equals(group.getCourse())) result.addAll(group.getStudents());
        }
        if (result.isEmpty()) throw new StudentNotFoundException();
        else return result;
    }

//    метод UniversityDB.addStudentToGroup(AbstractStudent student, AbstractGroup group) не synchronized потому что
//    к данной функции в БД могут получить доступ одновременно несколько акторов, однако добавить студента в
//    конкретную группу, только один, поэтому метод Group.addStudent(AbstractStudent student) помечен как synchronized.
    @Override
    public void addStudentToGroup(AbstractStudent student, AbstractGroup group)
            throws StudentAlreadyExistsException, GroupNotFoundException {
        if (!groups.contains(group)) throw new GroupNotFoundException();
        else group.addStudent(student);
    }

    @Override
    public Map<AbstractStudent, AbstractGroup> searchStudentsByCity(String city) throws StudentNotFoundException {
        Map<AbstractStudent, AbstractGroup> result = new HashMap<>();
        for (AbstractGroup group : groups) {
            try {
                for (AbstractStudent student : group.getStudentsByCity(city)) {
                    result.put(student, group);
                }
            } catch (StudentNotFoundException ignored) {
            }
        }
        if (result.isEmpty()) throw new StudentNotFoundException();
        else return result;
    }

    // тут вроде аналогично с UniversityDB.addStudentToGroup(AbstractStudent student, AbstractGroup group), но на
    // всякий случай пусть будет :/
    @Override
    public synchronized void moveStudentToGroup(AbstractStudent student, AbstractGroup target)
            throws StudentNotFoundException, GroupNotFoundException, StudentAlreadyExistsException {
        if (!groups.contains(target)) throw new GroupNotFoundException();
        else {
            try {
                AbstractGroup source = getStudentGroup(student);
                target.addStudent(student);
                source.removeStudent(student);
            } catch (GroupNotFoundException e) {
                throw new StudentNotFoundException(e);
            }
        }
    }

    @Override
    public void setStudentStatus(AbstractStudent student, Boolean status) throws StudentNotFoundException {
        try {
            getStudentGroup(student);
            student.setStatus(status);
        } catch (GroupNotFoundException e) {
            throw new StudentNotFoundException(e);
        }
    }

    private AbstractGroup getStudentGroup(AbstractStudent student) throws GroupNotFoundException {
        AbstractGroup result = null;
        for (AbstractGroup group : groups) {
            if (group.contains(student)) {
                result = group;
                break;
            }
        }
        if (result == null) throw new GroupNotFoundException();
        else return result;
    }
}
