package abstraction;

import exception.BoardAlreadyExistsException;
import exception.BoardNotFoundException;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

import java.util.List;
import java.util.Map;

public interface AbstractLibrary {
    List<AbstractBook> searchBooksByAuthor(String author, AbstractBoard board) throws BookNotFoundException,
            BoardNotFoundException;

    List<AbstractBook> searchBooksByTitle(String title, AbstractBoard board) throws BookNotFoundException,
            BoardNotFoundException;

    Map<AbstractBook, AbstractBoard> searchBooksByAuthor(String author) throws BookNotFoundException;

    Map<AbstractBook, AbstractBoard> searchBooksByTitle(String title) throws BookNotFoundException;

    AbstractBoard getNextBoard(AbstractBoard board) throws BoardNotFoundException;

    AbstractBoard getPreviousBoard(AbstractBoard board) throws BoardNotFoundException;

    void addBookToBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookAlreadyExistsException;

    void removeBookFromBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookNotFoundException;

    void addBoard(AbstractBoard board) throws BoardAlreadyExistsException;

    boolean contains(AbstractBoard board);

    AbstractBoard getFirstBoard();

    AbstractBoard getLastBoard();
}