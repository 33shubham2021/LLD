package problems.library_management_system;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private final String id;
    private final String name;
    private final String version;
    private final Category category;
    private BookState state;

    // Observer list — users waiting for this book to become available
    private final List<User> waitingQueue = new ArrayList<>();

    public Book(String id, String name, String version, Category category) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.category = category;
        this.state = new AvailableState(); // starts out available
    }

    // ---- State pattern delegation ----
    public void allocate(User user) {
        state.allocate(this, user);
    }

    public void returnBook() {
        state.returnBook(this);
    }

    public void setState(BookState state) {
        this.state = state;
    }

    public BookState getState() {
        return state;
    }

    public boolean isAvailable() {
        return state instanceof AvailableState;
    }

    // ---- Observer pattern: reservation queue ----
    public void addObserver(User user) {
        if (!waitingQueue.contains(user)) {
            waitingQueue.add(user);
            System.out.println(user.getName() + " added to waiting queue for \"" + name + "\"");
        }
    }

    public void notifyObservers() {
        if (!waitingQueue.isEmpty()) {
            User next = waitingQueue.remove(0);
            System.out.println("Notifying " + next.getName() + ": \"" + name + "\" is now available!");
            next.onBookAvailable(this);
        }
    }

    // ---- Getters ----
    public String getId() { return id; }
    public String getName() { return name; }
    public String getVersion() { return version; }
    public Category getCategory() { return category; }

    /** Composite key used by Library's lookup map to disambiguate same-name editions */
    public String getSearchKey() {
        return name + "_" + version;
    }

    @Override
    public String toString() {
        return "Book{id='" + id + "', name='" + name + "', version='" + version
                + "', category=" + category + ", state=" + state.getClass().getSimpleName() + "}";
    }
}

