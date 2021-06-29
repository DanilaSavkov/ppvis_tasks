package abstraction;

import java.util.Date;

public interface AbstractDocument {
    String getTitle();

    Date getCreationDate();

    AbstractAuthor getAuthor();

    String getText();

    void setText(String text);

    void setTitle(String title);

    boolean hasSameTitle(AbstractDocument document);
}
