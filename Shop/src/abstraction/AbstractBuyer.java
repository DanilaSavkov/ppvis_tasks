package abstraction;

import exception.BoardNotFoundException;
import exception.OverdueProductException;
import exception.ProductAlreadyExistsException;
import exception.ProductNotFoundException;

public interface AbstractBuyer {
    AbstractProduct searchProduct(AbstractBoard board, String type) throws ProductNotFoundException,
            BoardNotFoundException;

    AbstractBoard getPersonalBoard();

    void pickupProduct(AbstractProduct product) throws OverdueProductException, ProductNotFoundException, ProductAlreadyExistsException;
}
