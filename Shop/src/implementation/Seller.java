package implementation;

import abstraction.AbstractBoard;
import abstraction.AbstractProduct;
import abstraction.AbstractSeller;
import abstraction.AbstractShop;
import exception.BoardNotFoundException;
import exception.ProductAlreadyExistsException;
import exception.ProductNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Seller implements AbstractSeller {
    private final AbstractShop shop;

    public Seller(AbstractShop shop) {
        this.shop = shop;
    }

    @Override
    public AbstractProduct createProduct(String name, String type, Date expirationDate) {
        return new Product(name, type, expirationDate);
    }

    @Override
    public void addProductToBoard(AbstractProduct product, AbstractBoard board) throws ProductAlreadyExistsException,
            BoardNotFoundException {
        shop.addProductToBoard(product, board);
    }

    @Override
    public Map<AbstractProduct, AbstractBoard> searchProductsByName(String name) throws ProductNotFoundException {
        return shop.searchProductsByName(name);
    }

    @Override
    public List<AbstractProduct> searchOverdueProducts() throws ProductNotFoundException {
        return shop.searchOverdueProducts();
    }
}
