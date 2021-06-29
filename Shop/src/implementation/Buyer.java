package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractBuyer;
import abstraction.AbstractProduct;
import abstraction.AbstractShop;
import exception.BoardNotFoundException;
import exception.OverdueProductException;
import exception.ProductAlreadyExistsException;
import exception.ProductNotFoundException;

public class Buyer implements AbstractBuyer {
    private final AbstractShop shop;
    private final AbstractBoard personalBoard;

    public Buyer(AbstractShop shop, AbstractBoard personalBoard) {
        this.shop = shop;
        this.personalBoard = personalBoard;
    }

    @Override
    public AbstractProduct searchProduct(AbstractBoard board, String type) throws ProductNotFoundException, BoardNotFoundException {
        return shop.searchProductOnBoard(board, type);
    }

    @Override
    public AbstractBoard getPersonalBoard() {
        return personalBoard;
    }

    @Override
    public void pickupProduct(AbstractProduct product) throws OverdueProductException, ProductNotFoundException,
            ProductAlreadyExistsException {
        AbstractBoard board = shop.searchProductBoard(product);
        if (product.isOverdue()) throw new OverdueProductException();
        personalBoard.addProduct(product);
        board.removeProduct(product);
    }
}
