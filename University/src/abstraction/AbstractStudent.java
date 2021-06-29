package abstraction;

public interface AbstractStudent {
    String getSurname();

    String getCity();

    boolean isStudying();

    void setStudying(boolean status);

    boolean hasSameSurname(AbstractStudent student);
}
