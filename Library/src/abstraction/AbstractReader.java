package abstraction;

import exception.BoardNotFoundException;
import exception.BookNotFoundException;

import java.util.List;

public interface AbstractReader extends LibraryLocated {
    List<AbstractBook> searchBooksByAuthor(String author) throws BookNotFoundException, BoardNotFoundException;

    List<AbstractBook> searchBooksByTitle(String title) throws BookNotFoundException, BoardNotFoundException;

    @Override
    void setLibrary(AbstractLibrary library);

    void moveToNextBoard() throws BoardNotFoundException;

    void moveToPreviousBoard() throws BoardNotFoundException;
}