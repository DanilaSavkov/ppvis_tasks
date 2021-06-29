package implementation;

import abstraction.AbstractProduct;

import java.util.Date;

public class Product implements AbstractProduct {
    private final String name;
    private final String type;
    private final Date expirationDate;

    public Product(String name, String type, Date expirationDate) {
        this.name = name;
        this.type = type;
        this.expirationDate = expirationDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public boolean isOverdue() {
        return expirationDate.before(new Date());
    }

    @Override
    public boolean hasSameType(AbstractProduct product) {
        return type.equals(product.getType());
    }
}