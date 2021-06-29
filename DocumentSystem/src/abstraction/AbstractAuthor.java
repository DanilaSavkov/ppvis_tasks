package abstraction;

import exception.DocumentNotFoundException;

import java.util.List;

public interface AbstractAuthor {
    AbstractDocument createDocument(String title, String text);

    void updateDocument(AbstractDocument document, String title, String text) throws DocumentNotFoundException;

    List<AbstractDocument> searchDocumentsByTitle(String title) throws DocumentNotFoundException;
}
