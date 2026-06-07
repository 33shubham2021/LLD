package problems.library_management_system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

/**
 * SINGLETON PATTERN (thread-safe via double-checked locking).
 *
 * `volatile` is required here — without it the JVM/CPU may reorder the three
 * sub-steps of `new Library()` (allocate memory -> assign reference -> run
 * constructor). A second thread could observe a non-null reference whose
 * constructor hasn't finished running yet, i.e. a partially-constructed
 * Singleton. `volatile` establishes a happens-before edge that forbids that
 * reordering, on top of providing cross-thread visibility.
 */
public class Library {
    private static volatile Library instance;

    private final List<Book> books = new ArrayList<>();
    private final Map<String, Book> bookIndex = new HashMap<>(); // key: name_version -> Book
    private final List<Booking> bookings = new ArrayList<>();

    private SearchStrategy searchStrategy = new SearchByName();

    // Single, library-wide fine rate (kept simple per design discussion scope)
    private static final double FINE_PER_DAY = 5.0;

    private int bookCounter = 0;
    private int bookingCounter = 0;

    private Library() {
        // private constructor — only getInstance() can create it
    }

    public static Library getInstance() {
        if (instance == null) {                      // 1st check (no lock — fast path)
            synchronized (Library.class) {
                if (instance == null) {              // 2nd check (inside lock)
                    instance = new Library();
                }
            }
        }
        return instance;
    }

    // ---- Strategy pattern hook ----
    public void setSearchStrategy(SearchStrategy strategy) {
        this.searchStrategy = strategy;
    }

    // ---- Book management ----
    public synchronized Book addBook(String name, String version, Category category) {
        String id = "BK-" + (++bookCounter);
        Book book = new Book(id, name, version, category);
        books.add(book);
        bookIndex.put(book.getSearchKey(), book);
        System.out.println("Added: " + book);
        return book;
    }

    public synchronized void removeBook(Book book) {
        books.remove(book);
        bookIndex.remove(book.getSearchKey());
        System.out.println("Removed: " + book.getName());
    }

    public List<Book> findBooks(String query) {
        return searchStrategy.search(books, query);
    }

    /** O(1) lookup when caller knows the exact name + version (the composite key fix). */
    public Book findExact(String name, String version) {
        return bookIndex.get(name + "_" + version);
    }

    // ---- Booking lifecycle ----
    public synchronized Booking allocateBook(Book book, User user, int loanDays) {
        if (!book.isAvailable()) {
            // delegates to CheckedOutState -> registers user as observer
            book.allocate(user);
            return null;
        }

        book.allocate(user); // AvailableState -> CheckedOutState

        String id = "BKG-" + (++bookingCounter);
        LocalDate from = LocalDate.now();
        LocalDate to = from.plusDays(loanDays);
        Booking booking = new Booking(id, book, user, from, to);

        bookings.add(booking);
        user.addBooking(booking);
        return booking;
    }

    public synchronized double returnBook(Booking booking) {
        LocalDate returnDate = LocalDate.now();
        booking.markReturned(returnDate);
        booking.getBook().returnBook(); // CheckedOutState -> AvailableState, fires Observer notification
        return calculateFine(booking);
    }

    /** Fine calculation — guards against null/garbage dates per the edge-case discussion. */
    public double calculateFine(Booking booking) {
        LocalDate due = booking.getToDate();
        LocalDate returned = booking.getReturnDate();

        if (due == null || returned == null) return 0.0;
        if (!returned.isAfter(due)) return 0.0; // returned on/before due date -> no fine

        long daysLate = ChronoUnit.DAYS.between(due, returned);
        return daysLate * FINE_PER_DAY;
    }

    public List<Book> getAllBooks() {
        return Collections.unmodifiableList(books);
    }
}
