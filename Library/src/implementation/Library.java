package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractBook;
import abstraction.AbstractLibrary;
import exception.BoardAlreadyExistsException;
import exception.BoardNotFoundException;
import exception.BookAlreadyExistsException;
import exception.BookNotFoundException;

import java.util.*;

public class Library implements AbstractLibrary {
    private LinkedList<AbstractBoard> boards;

    public Library() {
    }

    @Override
    public List<AbstractBook> searchBooksByAuthor(String author, AbstractBoard board) throws BookNotFoundException,
            BoardNotFoundException {
        if (!contains(board)) throw new BoardNotFoundException();
        else return board.getBooksByAuthor(author);
    }

    @Override
    public List<AbstractBook> searchBooksByTitle(String title, AbstractBoard board) throws BookNotFoundException,
            BoardNotFoundException {
        if (!contains(board)) throw new BoardNotFoundException();
        else return board.getBooksByTitle(title);
    }

    @Override
    public Map<AbstractBook, AbstractBoard> searchBooksByAuthor(String author) throws BookNotFoundException {
        Map<AbstractBook, AbstractBoard> result = new HashMap<>();
        for (AbstractBoard board : boards) {
            try {
                result.putAll(board.searchBooksByAuthor(author));
            } catch (BookNotFoundException ignored) {}
        }
        if (result.isEmpty()) throw new BookNotFoundException();
        else return result;
    }

    @Override
    public Map<AbstractBook, AbstractBoard> searchBooksByTitle(String title) throws BookNotFoundException {
        Map<AbstractBook, AbstractBoard> result = new HashMap<>();
        for (AbstractBoard board : boards) {
            try {
                result.putAll(board.searchBooksByTitle(title));
            } catch (BookNotFoundException ignored) {}
        }
        if (result.isEmpty()) throw new BookNotFoundException();
        else return result;
    }

    @Override
    public AbstractBoard getNextBoard(AbstractBoard board) throws BoardNotFoundException {
        if (!contains(board)) throw new BoardNotFoundException();
        else if (board.equals(boards.getLast())) throw new BoardNotFoundException();
        else return boards.get(boards.indexOf(board) + 1);
    }

    @Override
    public AbstractBoard getPreviousBoard(AbstractBoard board) throws BoardNotFoundException {
        if (!contains(board)) throw new BoardNotFoundException();
        else if (board.equals(boards.getFirst())) throw new BoardNotFoundException();
        else return boards.get(boards.indexOf(board) - 1);
    }

    @Override
    public void addBookToBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookAlreadyExistsException {
        if (!contains(board)) throw new BoardNotFoundException();
        else board.addBook(book);
    }

    @Override
    public void removeBookFromBoard(AbstractBook book, AbstractBoard board) throws BoardNotFoundException,
            BookNotFoundException {
        if (!contains(board)) throw new BoardNotFoundException();
        else board.removeBook(book);
    }

    @Override
    public synchronized void addBoard(AbstractBoard board) throws BoardAlreadyExistsException {
        if (contains(board)) throw new BoardAlreadyExistsException();
        else boards.addLast(board);
    }

    @Override
    public boolean contains(AbstractBoard board) {
        return boards.contains(board);
    }

    @Override
    public AbstractBoard getFirstBoard() {
        return boards.getFirst();
    }

    @Override
    public AbstractBoard getLastBoard() {
        return boards.getLast();
    }
}