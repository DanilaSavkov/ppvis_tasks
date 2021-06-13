package implementation;

import abstraction.AbstractStudent;

public class Student implements AbstractStudent {
    private final String surname;
    private final String city;
    private Boolean status;

    public Student(String surname, String city) {
        this.surname = surname;
        this.city = city;
        status = false;
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
    public Boolean getStatus() {
        return status;
    }

    @Override
    public synchronized void setStatus(Boolean status) {
        this.status = status;
    }
}
