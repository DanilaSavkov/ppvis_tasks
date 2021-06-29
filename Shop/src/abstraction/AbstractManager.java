package abstraction;

import exception.BoardAlreadyExistsException;
import exception.BoardNotFoundException;
import exception.ProductNotFoundException;

import java.util.List;

public interface AbstractManager {
    void removeBoard(AbstractBoard board) throws BoardNotFoundException;

    void addBoard(AbstractBoard board) throws BoardAlreadyExistsException;

    List<AbstractProduct> searchOverdueProducts() throws ProductNotFoundException;

    List<AbstractProduct> searchProductsByType(String type) throws ProductNotFoundException;
}
