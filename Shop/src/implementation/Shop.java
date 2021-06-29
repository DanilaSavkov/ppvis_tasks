package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractProduct;
import abstraction.AbstractShop;
import exception.BoardAlreadyExistsException;
import exception.BoardNotFoundException;
import exception.ProductAlreadyExistsException;
import exception.ProductNotFoundException;

import java.util.*;

public class Shop implements AbstractShop {
    private final LinkedList<AbstractBoard> boards;

    public Shop() {
        this.boards = new LinkedList<>();
    }

    @Override
    public Map<AbstractProduct, AbstractBoard> searchProductsByName(String name) throws ProductNotFoundException {
        Map<AbstractProduct, AbstractBoard> result = new HashMap<>();
        for (AbstractBoard board : boards) {
            try {
                result.putAll(board.searchProductsByName(name));
            } catch (ProductNotFoundException ignored) {
            }
        }
        if (result.isEmpty()) throw new ProductNotFoundException();
        return result;
    }

    @Override
    public List<AbstractProduct> searchOverdueProducts() throws ProductNotFoundException {
        List<AbstractProduct> result = new ArrayList<>();
        for (AbstractBoard board : boards) {
            try {
                result.addAll(board.searchOverdueProducts());
            } catch (ProductNotFoundException ignored) {
            }
        }
        if (result.isEmpty()) throw new ProductNotFoundException();
        return result;
    }

    @Override
    public List<AbstractProduct> searchProductsByType(String type) throws ProductNotFoundException {
        List<AbstractProduct> result = new ArrayList<>();
        for (AbstractBoard board : boards) {
            try {
                result.add(board.searchProductByType(type));
            } catch (ProductNotFoundException ignored) {
            }
        }
        if (result.isEmpty()) throw new ProductNotFoundException();
        return result;
    }

    @Override
    public AbstractProduct searchProductOnBoard(AbstractBoard board, String type) throws ProductNotFoundException,
            BoardNotFoundException {
        if (!containsBoard(board)) throw new BoardNotFoundException();
        return board.searchProductByType(type);
    }

    @Override
    public void addProductToBoard(AbstractProduct product, AbstractBoard board) throws ProductAlreadyExistsException,
            BoardNotFoundException {
        if (!containsBoard(board)) throw new BoardNotFoundException();
        board.addProduct(product);
    }

    @Override
    public synchronized void removeBoard(AbstractBoard board) throws BoardNotFoundException {
        if (!containsBoard(board)) throw new BoardNotFoundException();
        boards.remove(board);
    }

    @Override
    public synchronized void addBoard(AbstractBoard board) throws BoardAlreadyExistsException {
        if (containsBoard(board)) throw new BoardAlreadyExistsException();
        boards.add(board);
    }

    private boolean containsBoard(AbstractBoard board) {
        for (AbstractBoard abstractBoard : boards) {
            if (board.getName().equals(abstractBoard.getName())) return true;
        }
        return false;
    }

    @Override
    public AbstractBoard searchProductBoard(AbstractProduct product) throws ProductNotFoundException {
        for (AbstractBoard board : boards) {
            for (AbstractProduct productOnBoard : board.getProducts()) {
                if (product.equals(productOnBoard)) return board;
            }
        }
        throw new ProductNotFoundException();
    }
}
