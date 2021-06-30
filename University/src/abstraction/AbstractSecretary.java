package abstraction;

import exception.GroupAlreadyExistsException;
import exception.GroupNotFoundException;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;

import java.util.List;

public interface AbstractSecretary extends UniversityWorker {
    void createGroup(String name, Integer course) throws GroupAlreadyExistsException;

    void remoteGroup(AbstractGroup group) throws GroupNotFoundException;

    List<AbstractStudent> getStudentsByGroup(AbstractGroup group) throws GroupNotFoundException;

    List<AbstractStudent> getStudentsByCourse(Integer course) throws StudentNotFoundException;

    void addStudentToGroup(AbstractStudent student, AbstractGroup group) throws StudentAlreadyExistsException,
            GroupNotFoundException;
}
