package abstraction;

import exception.GroupNotFoundException;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;
import exception.StudentNotStudyingException;

import java.util.Map;

public interface AbstractDean extends UniversityWorker {
    void changeStudentStatus(AbstractStudent student, boolean status) throws StudentNotFoundException;

    Map<AbstractStudent, AbstractGroup> searchStudentsByCity(String city) throws StudentNotFoundException;

    void moveStudentToGroup(AbstractStudent student, AbstractGroup target) throws StudentNotFoundException,
            StudentAlreadyExistsException, GroupNotFoundException, StudentNotStudyingException;
}