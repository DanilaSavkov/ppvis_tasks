package abstraction;

import exception.BoardAlreadyExistsException;
import exception.BoardNotFoundException;
import exception.ProductAlreadyExistsException;
import exception.ProductNotFoundException;

import java.util.List;
import java.util.Map;

public interface AbstractShop {
    Map<AbstractProduct, AbstractBoard> searchProductsByName(String name) throws ProductNotFoundException;

    List<AbstractProduct> searchOverdueProducts() throws ProductNotFoundException;

    List<AbstractProduct> searchProductsByType(String type) throws ProductNotFoundException;

    AbstractProduct searchProductOnBoard(AbstractBoard board, String type) throws ProductNotFoundException,
            BoardNotFoundException;

    void addProductToBoard(AbstractProduct product, AbstractBoard board) throws ProductAlreadyExistsException,
            BoardNotFoundException;

    void removeBoard(AbstractBoard board) throws BoardNotFoundException;

    void addBoard(AbstractBoard board) throws BoardAlreadyExistsException;

    AbstractBoard searchProductBoard(AbstractProduct product) throws ProductNotFoundException;
}