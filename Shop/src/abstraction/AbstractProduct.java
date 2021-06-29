package abstraction;

import java.util.Date;

public interface AbstractProduct {
    String getName();

    String getType();

    Date getExpirationDate();

    boolean isOverdue();

    boolean hasSameType(AbstractProduct product);
}