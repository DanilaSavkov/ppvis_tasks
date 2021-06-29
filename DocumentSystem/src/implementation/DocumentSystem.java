package implementation;

import abstraction.AbstractAuthor;
import abstraction.AbstractDocument;
import abstraction.AbstractDocumentSystem;
import abstraction.AbstractPackage;
import exception.DocumentAlreadyExistsException;
import exception.DocumentNotFoundException;
import exception.PackageAlreadyExistsException;
import exception.PackageNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class DocumentSystem implements AbstractDocumentSystem {
    private final AbstractPackage root;

    public DocumentSystem() {
        root = new Package("root");
    }

    @Override
    public void addDocumentToPackage(AbstractDocument document, AbstractPackage pack) throws PackageNotFoundException,
            DocumentAlreadyExistsException {
        if (!contains(pack)) throw new PackageNotFoundException();
        pack.addDocument(document);
    }

    @Override
    public List<AbstractDocument> searchDocumentsByAuthor(AbstractAuthor author) throws DocumentNotFoundException {
        List<AbstractDocument> result = new ArrayList<>();
        searchDocumentsByAuthorRecursion(root, author, result);
        return result;
    }

    private void searchDocumentsByAuthorRecursion(AbstractPackage root, AbstractAuthor author,
                                                  List<AbstractDocument> result) {
        try {
            result.addAll(root.searchDocumentsByAuthor(author));
        } catch (DocumentNotFoundException ignored) {
        }
        for (AbstractPackage abstractPackage : root.getPackages()) {
            searchDocumentsByAuthorRecursion(abstractPackage, author, result);
        }
    }

    @Override
    public List<AbstractDocument> searchDocumentsByTitle(String title) throws DocumentNotFoundException {
        List<AbstractDocument> result = new ArrayList<>();
        searchDocumentsByTitleRecursion(root, title, result);
        return result;
    }

    private void searchDocumentsByTitleRecursion(AbstractPackage root, String title, List<AbstractDocument> result) {
        try {
            result.add(root.searchDocumentByTitle(title));
        } catch (DocumentNotFoundException ignored) {
        }
        for (AbstractPackage abstractPackage : root.getPackages()) {
            searchDocumentsByTitleRecursion(abstractPackage, title, result);
        }
    }

    @Override
    public synchronized void removeDocument(AbstractDocument document) throws DocumentNotFoundException {
        if (!contains(document)) throw new DocumentNotFoundException();
        AbstractPackage pack = findDocumentPackage(root, document);
        if (pack == null) throw new DocumentNotFoundException();
        pack.removeDocument(document);
    }

    @Override
    public synchronized void moveDocument(AbstractDocument document, AbstractPackage pack) throws DocumentNotFoundException,
            PackageNotFoundException, DocumentAlreadyExistsException {
        if (!contains(pack)) throw new PackageNotFoundException();
        if (!contains(document)) throw new DocumentNotFoundException();
        if (!pack.contains(document)) {
            removeDocument(document);
            pack.addDocument(document);
        }
    }

    @Override
    public synchronized void createPackage(String name, AbstractPackage parent) throws PackageNotFoundException,
            PackageAlreadyExistsException {
        if (!contains(parent)) throw new PackageNotFoundException();
        parent.addPackage(new Package(name));
    }

    @Override
    public synchronized void updateDocument(AbstractDocument document, String title, String text) throws DocumentNotFoundException {
        if (!contains(document)) throw new DocumentNotFoundException();
        document.setTitle(title);
        document.setText(text);
    }

    @Override
    public boolean contains(AbstractPackage pack) {
        return containsRecursion(root, pack);
    }

    private boolean containsRecursion(AbstractPackage root, AbstractPackage pack) {
        if (root.getPackages().contains(pack)) return true;
        else {
            for (AbstractPackage abstractPackage : root.getPackages()) {
                containsRecursion(abstractPackage, pack);
            }
        }
        return false;
    }

    @Override
    public boolean contains(AbstractDocument document) {
        return containsRecursion(root, document);
    }

    private boolean containsRecursion(AbstractPackage root, AbstractDocument doc) {
        if (root.getDocuments().contains(doc)) return true;
        else {
            for (AbstractPackage abstractPackage : root.getPackages()) {
                containsRecursion(abstractPackage, doc);
            }
        }
        return false;
    }

    private AbstractPackage findDocumentPackage(AbstractPackage root, AbstractDocument doc) {
        if (root.getDocuments().contains(doc)) return root;
        else {
            for (AbstractPackage abstractPackage : root.getPackages()) {
                containsRecursion(abstractPackage, doc);
            }
        }
        return null;
    }
}
