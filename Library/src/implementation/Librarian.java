package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractBook;
import abstraction.AbstractLibrarian;
import abstraction.AbstractLibrary;
import exception.BoardNotFoundException;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

import java.util.Map;

public class Librarian implements AbstractLibrarian {
    private AbstractLibrary library;

    public Librarian(AbstractLibrary library) {
        this.library = library;
    }

    @Override
    public Map<AbstractBook, AbstractBoard> searchBooksByAuthor(String author) throws BookNotFoundException {
        return library.searchBooksByAuthor(author);
    }

    @Override
    public Map<AbstractBook, AbstractBoard> searchBooksByTitle(String title) throws BookNotFoundException {
        return library.searchBooksByTitle(title);
    }

    @Override
    public void addBookToBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookAlreadyExistsException {
        library.addBookToBoard(book, board);
    }

    @Override
    public void setLibrary(AbstractLibrary library) {
        this.library = library;
    }
}