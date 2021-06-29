package abstraction;

import exception.DocumentAlreadyExistsException;
import exception.DocumentNotFoundException;
import exception.PackageAlreadyExistsException;
import exception.PackageNotFoundException;

import java.util.List;

public interface AbstractDocumentSystem {
    void addDocumentToPackage(AbstractDocument document, AbstractPackage pack) throws PackageNotFoundException,
            DocumentAlreadyExistsException;

    List<AbstractDocument> searchDocumentsByAuthor(AbstractAuthor author) throws DocumentNotFoundException;

    List<AbstractDocument> searchDocumentsByTitle(String title) throws DocumentNotFoundException;

    void removeDocument(AbstractDocument document) throws DocumentNotFoundException;

    void moveDocument(AbstractDocument document, AbstractPackage pack) throws DocumentNotFoundException,
            PackageNotFoundException, DocumentAlreadyExistsException;

    void createPackage(String name, AbstractPackage parent) throws PackageNotFoundException,
            PackageAlreadyExistsException;

    void updateDocument(AbstractDocument document, String title, String text) throws DocumentNotFoundException;

    boolean contains(AbstractPackage pack);

    boolean contains(AbstractDocument document);
}
