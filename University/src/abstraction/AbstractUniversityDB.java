package abstraction;

import exception.GroupAlreadyExistsException;
import exception.GroupNotFoundException;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;

import java.util.List;
import java.util.Map;

public interface AbstractUniversityDB {
    List<AbstractStudent> getStudentsByGroup(AbstractGroup group) throws GroupNotFoundException;

    Map<AbstractStudent, AbstractGroup> searchStudentsBySurname(String surname) throws StudentNotFoundException;

    void addGroup(AbstractGroup group) throws GroupAlreadyExistsException;

    void removeGroup(AbstractGroup group) throws GroupNotFoundException;

    List<AbstractStudent> getStudentsByCourse(Integer course) throws StudentNotFoundException;

    void addStudentToGroup(AbstractStudent student, AbstractGroup group) throws StudentAlreadyExistsException,
            GroupNotFoundException;

    Map<AbstractStudent, AbstractGroup> searchStudentsByCity(String city) throws StudentNotFoundException;

    void moveStudentToGroup(AbstractStudent student, AbstractGroup target) throws StudentNotFoundException,
            GroupNotFoundException, StudentAlreadyExistsException;

    void setStudentStatus(AbstractStudent student, Boolean status) throws StudentNotFoundException;
}