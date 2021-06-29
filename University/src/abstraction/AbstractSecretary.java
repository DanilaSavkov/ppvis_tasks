package abstraction;

import exception.GroupAlreadyExistsException;
import exception.GroupNotFoundException;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;

import java.util.List;

public interface AbstractSecretary extends UniversityWorker {
    void createGroup(String name, int course) throws GroupAlreadyExistsException;

    void removeGroup(AbstractGroup group) throws GroupNotFoundException;

    List<AbstractStudent> getStudentsFromGroup(AbstractGroup group) throws GroupNotFoundException;

    List<AbstractStudent> getStudentsByCourse(int course) throws StudentNotFoundException;

    void addStudentToGroup(AbstractStudent student, AbstractGroup group) throws StudentAlreadyExistsException,
            GroupNotFoundException;
}
