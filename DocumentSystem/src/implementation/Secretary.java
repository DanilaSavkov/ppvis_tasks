package implementation;

import abstraction.*;
import exception.DocumentAlreadyExistsException;
import exception.DocumentNotFoundException;
import exception.PackageNotFoundException;

import java.util.List;

public class Secretary implements AbstractSecretary {
    private final AbstractDocumentSystem system;

    public Secretary(AbstractDocumentSystem system) {
        this.system = system;
    }

    @Override
    public void addDocumentToPackage(AbstractDocument document, AbstractPackage pack) throws PackageNotFoundException,
            DocumentAlreadyExistsException {
        system.addDocumentToPackage(document, pack);
    }

    @Override
    public List<AbstractDocument> searchDocumentsByAuthor(AbstractAuthor author) throws DocumentNotFoundException {
        return system.searchDocumentsByAuthor(author);
    }

    @Override
    public List<AbstractDocument> searchDocumentsByTitle(String title) throws DocumentNotFoundException {
        return system.searchDocumentsByTitle(title);
    }

    @Override
    public void removeDocument(AbstractDocument document) throws DocumentNotFoundException {
        system.removeDocument(document);
    }
}
