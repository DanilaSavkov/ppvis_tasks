package implementation;

import abstraction.AbstractDean;
import abstraction.AbstractGroup;
import abstraction.AbstractStudent;
import abstraction.AbstractUniversityDB;
import exception.GroupNotFoundException;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;
import exception.StudentNotStudyingException;

import java.util.Map;

public class Dean implements AbstractDean {
    private AbstractUniversityDB universityDB;

    public Dean(AbstractUniversityDB universityDB) {
        this.universityDB = universityDB;
    }

    @Override
    public void changeStudentStatus(AbstractStudent student, boolean status) throws StudentNotFoundException {
        universityDB.changeStudentStatus(student, status);
    }

    @Override
    public Map<AbstractStudent, AbstractGroup> searchStudentsByCity(String city) throws StudentNotFoundException {
        return universityDB.searchStudentsByCity(city);
    }

    @Override
    public void moveStudentToGroup(AbstractStudent student, AbstractGroup target) throws StudentNotFoundException,
            StudentAlreadyExistsException, GroupNotFoundException, StudentNotStudyingException {
        universityDB.moveStudentToGroup(student, target);
    }

    @Override
    public void setUniversityDB(AbstractUniversityDB universityDB) {
        this.universityDB = universityDB;
    }
}