package problems.library_management_system;

/**
 * STATE PATTERN
 * Each concrete state decides what allocate()/returnBook() does,
 * and what the *next* state is. Adding a new state (e.g. ReservedState,
 * UnderRepairState) means adding a new class — no existing code changes.
 * This satisfies the Open/Closed Principle.
 */
public interface BookState {
    void allocate(Book book, User user);
    void returnBook(Book book);
}
