package implementation;

import abstraction.AbstractAdmin;
import abstraction.AbstractDocument;
import abstraction.AbstractDocumentSystem;
import abstraction.AbstractPackage;
import exception.DocumentAlreadyExistsException;
import exception.DocumentNotFoundException;
import exception.PackageAlreadyExistsException;
import exception.PackageNotFoundException;

public class Admin implements AbstractAdmin {
    private final AbstractDocumentSystem system;

    public Admin(AbstractDocumentSystem system) {
        this.system = system;
    }

    @Override
    public void removeDocument(AbstractDocument document) throws DocumentNotFoundException {
        system.removeDocument(document);
    }

    @Override
    public void createPackage(String name, AbstractPackage parent) throws PackageAlreadyExistsException,
            PackageNotFoundException {
        system.createPackage(name, parent);
    }

    @Override
    public void moveDocument(AbstractDocument document, AbstractPackage pack) throws DocumentNotFoundException,
            PackageNotFoundException, DocumentAlreadyExistsException {
        system.moveDocument(document, pack);
    }
}
