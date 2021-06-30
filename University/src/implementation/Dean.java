package implementation;

import abstraction.AbstractDean;
import abstraction.AbstractGroup;
import abstraction.AbstractStudent;
import abstraction.AbstractUniversityDB;
import exception.GroupNotFoundException;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;

import java.util.Map;

public class Dean implements AbstractDean {
    private AbstractUniversityDB universityDB;

    public Dean(AbstractUniversityDB universityDB) {
        this.universityDB = universityDB;
    }

    @Override
    public void setStudentStatus(AbstractStudent student, Boolean status) throws StudentNotFoundException {
        universityDB.setStudentStatus(student, status);
    }

    @Override
    public Map<AbstractStudent, AbstractGroup> searchStudentsByCity(String city) throws StudentNotFoundException {
        return universityDB.searchStudentsByCity(city);
    }

    @Override
    public void moveStudent(AbstractStudent student, AbstractGroup target) throws StudentNotFoundException,
            StudentAlreadyExistsException, GroupNotFoundException {
        universityDB.moveStudentToGroup(student, target);
    }

    @Override
    public void setUniversityDB(AbstractUniversityDB universityDB) {
        this.universityDB = universityDB;
    }
}