package abstraction;

import exception.BoardAlreadyExistsException;
import exception.BoardNotFoundException;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

public interface AbstractManager extends LibraryLocated {
    @Override
    void setLibrary(AbstractLibrary library);

    void addBookToBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookAlreadyExistsException;

    void removeBookFromBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookNotFoundException;

    void addBoard(String name) throws BoardAlreadyExistsException;
}