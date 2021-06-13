package abstraction;

import exception.GroupNotFoundException;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;

import java.util.Map;

public interface AbstractDean extends UniversityWorker {
    void setStudentStatus(AbstractStudent student, Boolean status) throws StudentNotFoundException;

    Map<AbstractStudent, AbstractGroup> searchStudentsByCity(String city) throws StudentNotFoundException;

    void moveStudent(AbstractStudent student, AbstractGroup target) throws StudentNotFoundException,
            StudentAlreadyExistsException, GroupNotFoundException;
}