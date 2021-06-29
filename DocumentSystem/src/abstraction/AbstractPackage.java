package abstraction;

import exception.DocumentAlreadyExistsException;
import exception.DocumentNotFoundException;
import exception.PackageAlreadyExistsException;

import java.util.List;

public interface AbstractPackage {
    boolean contains(AbstractDocument document);

    boolean contains(AbstractPackage pack);

    String getName();

    List<AbstractDocument> getDocuments();

    List<AbstractPackage> getPackages();

    void addDocument(AbstractDocument document) throws DocumentAlreadyExistsException;

    List<AbstractDocument> searchDocumentsByAuthor(AbstractAuthor author) throws DocumentNotFoundException;

    AbstractDocument searchDocumentByTitle(String title) throws DocumentNotFoundException;

    void removeDocument(AbstractDocument document) throws DocumentNotFoundException;

    boolean hasSameName(AbstractPackage pack);

    void addPackage(AbstractPackage pack) throws PackageAlreadyExistsException;
}
