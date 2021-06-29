package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractManager;
import abstraction.AbstractProduct;
import abstraction.AbstractShop;
import exception.BoardAlreadyExistsException;
import exception.BoardNotFoundException;
import exception.ProductNotFoundException;

import java.util.List;

public class Manager implements AbstractManager {
    private final AbstractShop shop;

    public Manager(AbstractShop shop) {
        this.shop = shop;
    }

    @Override
    public void removeBoard(AbstractBoard board) throws BoardNotFoundException {
        shop.removeBoard(board);
    }

    @Override
    public void addBoard(AbstractBoard board) throws BoardAlreadyExistsException {
        shop.addBoard(board);
    }

    @Override
    public List<AbstractProduct> searchOverdueProducts() throws ProductNotFoundException {
        return shop.searchOverdueProducts();
    }

    @Override
    public List<AbstractProduct> searchProductsByType(String type) throws ProductNotFoundException {
        return shop.searchProductsByType(type);
    }
}
