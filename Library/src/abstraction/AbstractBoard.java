package abstraction;

import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

import java.util.List;
import java.util.Map;

public interface AbstractBoard {
    List<AbstractBook> getBooks() throws BookNotFoundException;

    String getName();

    List<AbstractBook> getBooksByAuthor(String author) throws BookNotFoundException;

    List<AbstractBook> getBooksByTitle(String title) throws BookNotFoundException;

    Map<AbstractBook, AbstractBoard> searchBooksByAuthor(String author) throws BookNotFoundException;

    Map<AbstractBook, AbstractBoard> searchBooksByTitle(String title) throws BookNotFoundException;

    void addBook(AbstractBook book) throws BookAlreadyExistsException;

    void removeBook(AbstractBook book) throws BookNotFoundException;

    boolean contains(AbstractBook book);
}