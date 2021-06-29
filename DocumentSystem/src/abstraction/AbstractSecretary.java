package abstraction;

import exception.DocumentAlreadyExistsException;
import exception.DocumentNotFoundException;
import exception.PackageNotFoundException;

import java.util.List;

public interface AbstractSecretary {
    void addDocumentToPackage(AbstractDocument document, AbstractPackage pack) throws PackageNotFoundException,
            DocumentAlreadyExistsException;

    List<AbstractDocument> searchDocumentsByAuthor(AbstractAuthor author) throws DocumentNotFoundException;

    List<AbstractDocument> searchDocumentsByTitle(String title) throws DocumentNotFoundException;

    void removeDocument(AbstractDocument document) throws DocumentNotFoundException;
}
