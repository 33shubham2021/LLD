package problems.library_management_system;

/**
 * OBSERVER PATTERN — contract for anything that wants to be notified
 * when a Book transitions back to AVAILABLE.
 */
public interface BookAvailabilityObserver {
    void onBookAvailable(Book book);
}
