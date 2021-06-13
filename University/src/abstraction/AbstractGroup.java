package abstraction;

import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;

import java.util.List;

public interface AbstractGroup {
    List<AbstractStudent> getStudents();

    AbstractStudent getStudentBySurname(String surname) throws StudentNotFoundException;

    void addStudent(AbstractStudent student) throws StudentAlreadyExistsException;

    void removeStudent(AbstractStudent student) throws StudentNotFoundException;

    List<AbstractStudent> getStudentsByCity(String city) throws StudentNotFoundException;

    Integer getCourse();

    String getName();

    void setCourse(Integer course);

    boolean contains(AbstractStudent student);
}
