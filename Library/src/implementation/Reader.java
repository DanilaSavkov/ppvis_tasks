package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractBook;
import abstraction.AbstractLibrary;
import abstraction.AbstractReader;
import exception.BoardNotFoundException;
import exception.BookNotFoundException;

import java.util.List;

public class Reader implements AbstractReader {
    private AbstractLibrary library;
    private AbstractBoard currentBoard;

    public Reader(AbstractLibrary library) {
        this.library = library;
        currentBoard = library.getFirstBoard();
    }

    @Override
    public List<AbstractBook> searchBooksByAuthor(String author) throws BookNotFoundException, BoardNotFoundException {
        return library.searchBooksByAuthor(author, currentBoard);
    }

    @Override
    public List<AbstractBook> searchBooksByTitle(String title) throws BookNotFoundException, BoardNotFoundException {
        return library.searchBooksByTitle(title, currentBoard);
    }

    @Override
    public void setLibrary(AbstractLibrary library) {
        this.library = library;
        currentBoard = library.getFirstBoard();
    }

    @Override
    public void moveToNextBoard() throws BoardNotFoundException {
        currentBoard = library.getNextBoard(currentBoard);
    }

    @Override
    public void moveToPreviousBoard() throws BoardNotFoundException {
        currentBoard = library.getPreviousBoard(currentBoard);
    }
}
