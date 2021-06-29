package abstraction;

import exception.*;

import java.util.List;
import java.util.Map;

public interface AbstractUniversityDB {
    List<AbstractStudent> getStudentsFromGroup(AbstractGroup group) throws GroupNotFoundException;

    Map<AbstractStudent, AbstractGroup> searchStudentsBySurname(String surname) throws StudentNotFoundException;

    void addGroup(AbstractGroup group) throws GroupAlreadyExistsException;

    void removeGroup(AbstractGroup group) throws GroupNotFoundException;

    List<AbstractStudent> getStudentsByCourse(int course) throws StudentNotFoundException;

    void addStudentToGroup(AbstractStudent student, AbstractGroup group) throws StudentAlreadyExistsException,
            GroupNotFoundException;

    Map<AbstractStudent, AbstractGroup> searchStudentsByCity(String city) throws StudentNotFoundException;

    void moveStudentToGroup(AbstractStudent student, AbstractGroup target) throws StudentNotFoundException,
            GroupNotFoundException, StudentAlreadyExistsException, StudentNotStudyingException;

    void changeStudentStatus(AbstractStudent student, boolean status) throws StudentNotFoundException;
}