package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractBook;
import abstraction.AbstractLibrary;
import abstraction.AbstractManager;
import exception.BoardAlreadyExistsException;
import exception.BoardNotFoundException;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

public class Manager implements AbstractManager {
    private AbstractLibrary library;

    public Manager(AbstractLibrary library) {
        this.library = library;
    }

    @Override
    public void setLibrary(AbstractLibrary library) {
        this.library = library;
    }

    @Override
    public void addBookToBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookAlreadyExistsException {
        library.addBookToBoard(book, board);
    }

    @Override
    public void removeBookFromBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookNotFoundException {
        library.removeBookFromBoard(book, board);
    }

    @Override
    public void addBoard(String name) throws BoardAlreadyExistsException {
        AbstractBoard board = new Board(name);
        library.addBoard(board);
    }
}
