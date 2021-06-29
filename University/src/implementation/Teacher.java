package implementation;

import abstraction.AbstractGroup;
import abstraction.AbstractStudent;
import abstraction.AbstractTeacher;
import abstraction.AbstractUniversityDB;
import exception.GroupNotFoundException;
import exception.StudentNotFoundException;

import java.util.List;
import java.util.Map;

public class Teacher implements AbstractTeacher {
    private AbstractUniversityDB universityDB;

    public Teacher(AbstractUniversityDB universityDB) {
        this.universityDB = universityDB;
    }

    @Override
    public List<AbstractStudent> getStudentsByGroup(AbstractGroup group) throws GroupNotFoundException {
        return universityDB.getStudentsFromGroup(group);
    }

    @Override
    public Map<AbstractStudent, AbstractGroup> searchStudentsBySurname(String surname) throws StudentNotFoundException {
        return universityDB.searchStudentsBySurname(surname);
    }

    @Override
    public void setUniversityDB(AbstractUniversityDB universityDB) {
        this.universityDB = universityDB;
    }
}
