package implementation;

import abstraction.AbstractGroup;
import abstraction.AbstractStudent;
import abstraction.AbstractUniversityDB;
import exception.*;

import java.util.*;

public class UniversityDB implements AbstractUniversityDB {
    private final Map<Integer, LinkedList<AbstractGroup>> data;

    public UniversityDB() {
        data = new HashMap<>();
    }

    @Override
    public List<AbstractStudent> getStudentsFromGroup(AbstractGroup group) throws GroupNotFoundException {
        List<AbstractGroup> groups = getGroupsByCourse(group.getCourse());
        if (!groups.contains(group)) throw new GroupNotFoundException();
        else return group.getStudents();
    }

    @Override
    public Map<AbstractStudent, AbstractGroup> searchStudentsBySurname(String surname) throws StudentNotFoundException {
        List<AbstractGroup> groups = getGroups();
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
        List<AbstractGroup> groups = getGroupsByCourse(group.getCourse());
        if (groups.contains(group)) throw new GroupAlreadyExistsException();
        else groups.add(group);
    }

    @Override
    public synchronized void removeGroup(AbstractGroup group) throws GroupNotFoundException {
        List<AbstractGroup> groups = getGroupsByCourse(group.getCourse());
        if (!groups.contains(group)) throw new GroupNotFoundException();
        else groups.remove(group);
    }

    @Override
    public List<AbstractStudent> getStudentsByCourse(int course) throws StudentNotFoundException {
        List<AbstractGroup> groups = getGroupsByCourse(course);
        List<AbstractStudent> result = new ArrayList<>();
        for (AbstractGroup group : groups) {
            result.addAll(group.getStudents());
        }
        if (result.isEmpty()) throw new StudentNotFoundException();
        else return result;
    }

    @Override
    public void addStudentToGroup(AbstractStudent student, AbstractGroup group)
            throws StudentAlreadyExistsException, GroupNotFoundException {
        List<AbstractGroup> groups = getGroupsByCourse(group.getCourse());
        if (!groups.contains(group)) throw new GroupNotFoundException();
        else group.addStudent(student);
    }

    @Override
    public Map<AbstractStudent, AbstractGroup> searchStudentsByCity(String city) throws StudentNotFoundException {
        List<AbstractGroup> groups = getGroups();
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

    @Override
    public synchronized void moveStudentToGroup(AbstractStudent student, AbstractGroup target)
            throws StudentNotFoundException, GroupNotFoundException, StudentAlreadyExistsException,
            StudentNotStudyingException {
        if (!student.isStudying()) throw new StudentNotStudyingException();
        List<AbstractGroup> groups = getGroupsByCourse(target.getCourse());
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
    public void changeStudentStatus(AbstractStudent student, boolean status) throws StudentNotFoundException {
        try {
            AbstractGroup group = getStudentGroup(student);
            student.setStudying(status);
            if (!status) group.removeStudent(student);
        } catch (GroupNotFoundException e) {
            throw new StudentNotFoundException(e);
        }
    }

    private AbstractGroup getStudentGroup(AbstractStudent student) throws GroupNotFoundException {
        List<AbstractGroup> groups = getGroups();
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

    private List<AbstractGroup> getGroupsByCourse(int course) {
        return data.get(course);
    }

    private List<AbstractGroup> getGroups() {
        List<AbstractGroup> result = new ArrayList<>();
        for (List<AbstractGroup> groups : data.values()) {
            result.addAll(groups);
        }
        return result;
    }
}