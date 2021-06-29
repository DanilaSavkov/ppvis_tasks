package abstraction;

import exception.ProductAlreadyExistsException;
import exception.ProductNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AbstractBoard {
    String getName();

    Set<String> getProductTypes();

    List<AbstractProduct> getProducts();

    AbstractProduct searchProductByType(String type) throws ProductNotFoundException;

    void addProduct(AbstractProduct product) throws ProductAlreadyExistsException;

    void removeProduct(AbstractProduct product) throws ProductNotFoundException;

    Map<AbstractProduct, AbstractBoard> searchProductsByName(String name) throws ProductNotFoundException;

    List<AbstractProduct> searchOverdueProducts() throws ProductNotFoundException;
}