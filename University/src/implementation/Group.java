package implementation;

import abstraction.AbstractGroup;
import abstraction.AbstractStudent;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Group implements AbstractGroup {
    private final List<AbstractStudent> students;
    private final String name;
    private int course;

    public Group(String name, int course) {
        this.name = name;
        this.course = course;
        students = new ArrayList<>();
    }

    @Override
    public List<AbstractStudent> getStudents() {
        return students;
    }

    @Override
    public AbstractStudent getStudentBySurname(String surname) throws StudentNotFoundException {
        for (AbstractStudent student : students) {
            if (surname.equals(student.getSurname())) return student;
        }
        throw new StudentNotFoundException();
    }

    @Override
    public synchronized void addStudent(AbstractStudent student) throws StudentAlreadyExistsException {
        if (containsSameSurname(student)) throw new StudentAlreadyExistsException();
        else students.add(student);
    }

    @Override
    public synchronized void removeStudent(AbstractStudent student) throws StudentNotFoundException {
        if (!contains(student)) throw new StudentNotFoundException();
        else students.remove(student);
    }

    @Override
    public List<AbstractStudent> getStudentsByCity(String city) throws StudentNotFoundException {
        List<AbstractStudent> result = new ArrayList<>();
        for (AbstractStudent student : students) {
            if (city.equals(student.getCity())) result.add(student);
        }
        if (result.isEmpty()) throw new StudentNotFoundException();
        else return result;
    }

    @Override
    public int getCourse() {
        return course;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean contains(AbstractStudent student) {
        return students.contains(student);
    }

    private boolean containsSameSurname(AbstractStudent student) {
        for (AbstractStudent abstractStudent : students) {
            if (student.hasSameSurname(abstractStudent)) return true;
        }
        return false;
    }
}