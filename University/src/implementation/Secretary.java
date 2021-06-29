package implementation;

import abstraction.AbstractGroup;
import abstraction.AbstractSecretary;
import abstraction.AbstractStudent;
import abstraction.AbstractUniversityDB;
import exception.GroupAlreadyExistsException;
import exception.GroupNotFoundException;
import exception.StudentAlreadyExistsException;
import exception.StudentNotFoundException;

import java.util.List;

public class Secretary implements AbstractSecretary {
    private AbstractUniversityDB universityDB;

    public Secretary(AbstractUniversityDB universityDB) {
        this.universityDB = universityDB;
    }

    @Override
    public void createGroup(String name, int course) throws GroupAlreadyExistsException {
        AbstractGroup group = new Group(name, course);
        universityDB.addGroup(group);
    }

    @Override
    public void removeGroup(AbstractGroup group) throws GroupNotFoundException {
        universityDB.removeGroup(group);
    }

    @Override
    public List<AbstractStudent> getStudentsFromGroup(AbstractGroup group) throws GroupNotFoundException {
        return universityDB.getStudentsFromGroup(group);
    }

    @Override
    public List<AbstractStudent> getStudentsByCourse(int course) throws StudentNotFoundException {
        return universityDB.getStudentsByCourse(course);
    }

    @Override
    public void addStudentToGroup(AbstractStudent student, AbstractGroup group) throws StudentAlreadyExistsException,
            GroupNotFoundException {
        universityDB.addStudentToGroup(student, group);
    }

    @Override
    public void setUniversityDB(AbstractUniversityDB universityDB) {
        this.universityDB = universityDB;
    }
}
