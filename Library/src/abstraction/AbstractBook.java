package abstraction;

public interface AbstractBook {
    String getTitle();

    String getAuthor();

    String getText();

    boolean hasSameCover(AbstractBook anotherBook);
}