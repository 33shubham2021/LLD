package problems.library_management_system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Manual test harness — exercises every flow discussed in the interview:
 *  - Add/find books (Strategy: name & category search)
 *  - Allocate / prevent double-allocation (State pattern)
 *  - Reservation queue + notification on return (Observer pattern)
 *  - Fine calculation on a late return
 *  - Singleton identity check
 */
public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();

        System.out.println("=== 1. Singleton check ===");
        Library again = Library.getInstance();
        System.out.println("Same instance? " + (library == again));

        System.out.println("\n=== 2. Adding books ===");
        Book cleanCodeV1 = library.addBook("Clean Code", "1st Edition", Category.TECHNOLOGY);
        Book cleanCodeV2 = library.addBook("Clean Code", "2nd Edition", Category.TECHNOLOGY);
        library.addBook("Sapiens", "1st Edition", Category.HISTORY);

        System.out.println("\n=== 3. Search by name (Strategy: SearchByName) ===");
        library.setSearchStrategy(new SearchByName());
        List<Book> found = library.findBooks("Clean Code");
        found.forEach(System.out::println);
        System.out.println("Note: both editions returned -> composite key (name+version) needed for exact lookup");
        System.out.println("Exact lookup -> " + library.findExact("Clean Code", "2nd Edition"));

        System.out.println("\n=== 4. Search by category (Strategy: SearchByCategory) ===");
        library.setSearchStrategy(new SearchByCategory());
        library.findBooks("TECHNOLOGY").forEach(System.out::println);

        System.out.println("\n=== 5. Allocate a book (State: Available -> CheckedOut) ===");
        User alice = new User("U-1", "Alice", "alice@mail.com", "9990001111");
        User bob   = new User("U-2", "Bob", "bob@mail.com", "9990002222");

        Booking aliceBooking = library.allocateBook(cleanCodeV1, alice, 7); // 7-day loan
        System.out.println("Created -> " + aliceBooking);
        System.out.println("Book state now: " + cleanCodeV1.getState().getClass().getSimpleName());

        System.out.println("\n=== 6. Bob tries to allocate the same (unavailable) book ===");
        Booking bobAttempt = library.allocateBook(cleanCodeV1, bob, 7);
        System.out.println("Bob's booking object: " + bobAttempt + "  (null -> registered as observer instead)");

        System.out.println("\n=== 7. Alice returns the book LATE -> Observer notifies Bob + fine is calculated ===");
        // Simulate a late return by backdating the booking's due date
        Booking lateBooking = new Booking("BKG-LATE", cleanCodeV1, alice,
                LocalDate.now().minusDays(10), LocalDate.now().minusDays(3));
        double fine = library.returnBook(lateBooking);
        long daysLate = ChronoUnit.DAYS.between(lateBooking.getToDate(), lateBooking.getReturnDate());
        System.out.println("Days late: " + daysLate + "  |  Fine charged: $" + fine);
        System.out.println("Book state now: " + cleanCodeV1.getState().getClass().getSimpleName());

        System.out.println("\n=== 8. On-time return -> no fine ===");
        Booking bobBooking = library.allocateBook(cleanCodeV2, bob, 7); // due 7 days from now
        double noFine = library.returnBook(bobBooking);                 // returned today -> well within window
        System.out.println("Fine charged: $" + noFine);

        System.out.println("\n=== 9. Remove a book ===");
        library.removeBook(cleanCodeV2);
        System.out.println("Remaining: " + library.getAllBooks().size() + " books");
    }
}
