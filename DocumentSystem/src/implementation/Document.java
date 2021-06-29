package implementation;

import abstraction.AbstractAuthor;
import abstraction.AbstractDocument;

import java.util.Date;

public class Document implements AbstractDocument {
    private String title;
    private final Date creationDate;
    private final AbstractAuthor author;
    private String text;

    public Document(String title, Date creationDate, AbstractAuthor author, String text) {
        this.title = title;
        this.creationDate = creationDate;
        this.author = author;
        this.text = text;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public AbstractAuthor getAuthor() {
        return author;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public synchronized void setText(String text) {
        this.text = text;
    }

    @Override
    public synchronized void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean hasSameTitle(AbstractDocument document) {
        return document.getTitle().equals(title);
    }
}
