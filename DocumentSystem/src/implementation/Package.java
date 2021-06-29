package implementation;

import abstraction.AbstractAuthor;
import abstraction.AbstractDocument;
import abstraction.AbstractPackage;
import exception.DocumentAlreadyExistsException;
import exception.DocumentNotFoundException;
import exception.PackageAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;

public class Package implements AbstractPackage {
    private final String name;
    private final List<AbstractDocument> documents;
    private final List<AbstractPackage> packages;

    public Package(String name) {
        this.name = name;
        documents = new ArrayList<>();
        packages = new ArrayList<>();
    }

    @Override
    public boolean contains(AbstractDocument document) {
        for (AbstractDocument doc : documents) {
            if (document.hasSameTitle(doc)) return true;
        }
        return false;
    }

    @Override
    public boolean contains(AbstractPackage pack) {
        for (AbstractPackage abstractPackage : packages) {
            if (pack.hasSameName(abstractPackage)) return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<AbstractDocument> getDocuments() {
        return documents;
    }

    @Override
    public List<AbstractPackage> getPackages() {
        return packages;
    }

    @Override
    public synchronized void addDocument(AbstractDocument document) throws DocumentAlreadyExistsException {
        if (contains(document)) throw new DocumentAlreadyExistsException();
        documents.add(document);
    }

    @Override
    public List<AbstractDocument> searchDocumentsByAuthor(AbstractAuthor author) throws DocumentNotFoundException {
        List<AbstractDocument> result = new ArrayList<>();
        for (AbstractDocument document : documents) {
            if (document.getAuthor().equals(author)) result.add(document);
        }
        if (result.isEmpty()) throw new DocumentNotFoundException();
        return result;
    }

    @Override
    public AbstractDocument searchDocumentByTitle(String title) throws DocumentNotFoundException {
        for (AbstractDocument document : documents) {
            if (document.getTitle().equals(title)) return document;
        }
        throw new DocumentNotFoundException();
    }

    @Override
    public synchronized void removeDocument(AbstractDocument document) throws DocumentNotFoundException {
        if (!documents.remove(document)) throw new DocumentNotFoundException();
    }

    @Override
    public boolean hasSameName(AbstractPackage pack) {
        return pack.getName().equals(name);
    }

    @Override
    public synchronized void addPackage(AbstractPackage pack) throws PackageAlreadyExistsException {
        if (contains(pack)) throw new PackageAlreadyExistsException();
        packages.add(pack);
    }
}
