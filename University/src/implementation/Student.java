package implementation;

import abstraction.AbstractStudent;

public class Student implements AbstractStudent {
    private final String surname;
    private final String city;
    private boolean studying;

    public Student(String surname, String city) {
        this.surname = surname;
        this.city = city;
        studying = false;
    }

    @Override
    public String getSurname() {
        return surname;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public boolean isStudying() {
        return studying;
    }

    @Override
    public boolean hasSameSurname(AbstractStudent student) {
        return student.getSurname().equals(surname);
    }

    @Override
    public synchronized void setStudying(boolean status) {
        this.studying = status;
    }
}
