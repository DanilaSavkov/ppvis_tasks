package abstraction;

import exception.DocumentAlreadyExistsException;
import exception.DocumentNotFoundException;
import exception.PackageAlreadyExistsException;
import exception.PackageNotFoundException;

public interface AbstractAdmin {
    void removeDocument(AbstractDocument document) throws DocumentNotFoundException;

    void createPackage(String name, AbstractPackage parent) throws PackageNotFoundException,
            PackageAlreadyExistsException;

    void moveDocument(AbstractDocument document, AbstractPackage pack) throws DocumentNotFoundException,
            PackageNotFoundException, DocumentAlreadyExistsException;
}
