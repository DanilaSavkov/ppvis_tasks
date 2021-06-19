package implementation;

import abstraction.AbstractBook;

public class Book implements AbstractBook {
    private final String title;
    private final String author;
    private final String text;

    public Book(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    @Override
    public String getText() {
        return text;
    }

    public boolean hasSameCover(AbstractBook anotherBook) {
        return this.author.equals(anotherBook.getAuthor()) && this.title.equals(anotherBook.getTitle());
    }
}