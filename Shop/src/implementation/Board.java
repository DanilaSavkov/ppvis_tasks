package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractProduct;
import exception.ProductAlreadyExistsException;
import exception.ProductNotFoundException;

import java.util.*;

public class Board implements AbstractBoard {
    private final String name;
    private final Set<String> productTypes;
    private final List<AbstractProduct> products;

    public Board(String name) {
        this.name = name;
        productTypes = new HashSet<>();
        products = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Set<String> getProductTypes() {
        return productTypes;
    }

    @Override
    public List<AbstractProduct> getProducts() {
        return products;
    }

    @Override
    public AbstractProduct searchProductByType(String type) throws ProductNotFoundException {
        for (AbstractProduct product : products) {
            if (product.getType().equals(type)) return product;
        }
        throw new ProductNotFoundException();
    }

    @Override
    public synchronized void addProduct(AbstractProduct product) throws ProductAlreadyExistsException {
        if (containsType(product.getType())) throw new ProductAlreadyExistsException();
        products.add(product);
        productTypes.add(product.getType());
    }

    @Override
    public synchronized void removeProduct(AbstractProduct product) throws ProductNotFoundException {
        if (!products.contains(product)) throw new ProductNotFoundException();
        products.remove(product);
    }

    @Override
    public Map<AbstractProduct, AbstractBoard> searchProductsByName(String name) throws ProductNotFoundException {
        Map<AbstractProduct, AbstractBoard> result = new HashMap<>();
        for (AbstractProduct product : products) {
            if (product.getName().equals(name)) result.put(product, this);
        }
        if (result.isEmpty()) throw new ProductNotFoundException();
        return result;
    }

    @Override
    public List<AbstractProduct> searchOverdueProducts() throws ProductNotFoundException {
        List<AbstractProduct> result = new ArrayList<>();
        for (AbstractProduct product : products) {
            if (product.isOverdue()) result.add(product);
        }
        if (result.isEmpty()) throw new ProductNotFoundException();
        return result;
    }

    private boolean containsType(String type) {
        return productTypes.contains(type);
    }
}