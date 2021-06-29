package implementation;

import abstraction.AbstractAuthor;
import abstraction.AbstractDocument;
import abstraction.AbstractDocumentSystem;
import exception.DocumentNotFoundException;

import java.util.Date;
import java.util.List;

public class Author implements AbstractAuthor {
    private final AbstractDocumentSystem system;

    public Author(AbstractDocumentSystem system) {
        this.system = system;
    }

    @Override
    public AbstractDocument createDocument(String title, String text) {
        return new Document(title, new Date(), this, text);
    }

    @Override
    public void updateDocument(AbstractDocument document, String title, String text) throws DocumentNotFoundException {
        system.updateDocument(document, title, text);
    }

    @Override
    public List<AbstractDocument> searchDocumentsByTitle(String title) throws DocumentNotFoundException {
        return system.searchDocumentsByTitle(title);
    }
}
