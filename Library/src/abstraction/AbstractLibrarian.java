package abstraction;

import exception.BoardNotFoundException;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

import java.util.Map;

public interface AbstractLibrarian extends LibraryLocated {
    Map<AbstractBook, AbstractBoard> searchBooksByAuthor(String author) throws BookNotFoundException;

    Map<AbstractBook, AbstractBoard> searchBooksByTitle(String title) throws BookNotFoundException;

    void addBookToBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookAlreadyExistsException;

    @Override
    void setLibrary(AbstractLibrary library);
}