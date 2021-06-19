package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractBook;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

import java.util.*;

public class Board implements AbstractBoard {
    private final List<AbstractBook> books;
    private final String name;

    public Board(String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    @Override
    public List<AbstractBook> getBooks() throws BookNotFoundException {
        return books;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<AbstractBook> getBooksByAuthor(String author) throws BookNotFoundException {
        List<AbstractBook> result = new ArrayList<>();
        for (AbstractBook book : books) {
            if (author.equals(book.getAuthor())) result.add(book);
        }
        if (result.isEmpty()) throw new BookNotFoundException();
        return result;
    }

    @Override
    public List<AbstractBook> getBooksByTitle(String title) throws BookNotFoundException {
        List<AbstractBook> result = new ArrayList<>();
        for (AbstractBook book : books) {
            if (title.equals(book.getTitle())) result.add(book);
        }
        if (result.isEmpty()) throw new BookNotFoundException();
        return result;
    }

    @Override
    public Map<AbstractBook, AbstractBoard> searchBooksByAuthor(String author) throws BookNotFoundException {
        Map<AbstractBook, AbstractBoard> result = new HashMap<>();
        for (AbstractBook book : getBooksByAuthor(author)) result.put(book, this);
        return result;
    }

    @Override
    public Map<AbstractBook, AbstractBoard> searchBooksByTitle(String title) throws BookNotFoundException {
        Map<AbstractBook, AbstractBoard> result = new HashMap<>();
        for (AbstractBook book : getBooksByTitle(title)) result.put(book, this);
        return result;
    }

    @Override
    public synchronized void addBook(AbstractBook book) throws BookAlreadyExistsException {
        if (contains(book)) throw new BookAlreadyExistsException();
        else books.add(book);
    }

    @Override
    public synchronized void removeBook(AbstractBook book) throws BookNotFoundException {
        if (!contains(book)) throw new BookNotFoundException();
        else books.remove(book);
    }

    @Override
    public boolean contains(AbstractBook book) {
        for (AbstractBook abstractBook : books) {
            if (book.hasSameCover(abstractBook)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(name, board.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}