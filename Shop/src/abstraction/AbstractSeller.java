package abstraction;

import exception.BoardNotFoundException;
import exception.ProductAlreadyExistsException;
import exception.ProductNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AbstractSeller {
    AbstractProduct createProduct(String name, String type, Date expirationDate);

    void addProductToBoard(AbstractProduct product, AbstractBoard board) throws ProductAlreadyExistsException,
            BoardNotFoundException;

    Map<AbstractProduct, AbstractBoard> searchProductsByName(String name) throws ProductNotFoundException;

    List<AbstractProduct> searchOverdueProducts() throws ProductNotFoundException;
}
