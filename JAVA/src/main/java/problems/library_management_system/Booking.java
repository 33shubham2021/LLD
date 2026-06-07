package problems.library_management_system;

import java.time.LocalDate;

public class Booking {
    private final String id;
    private final Book book;
    private final User user;
    private final LocalDate fromDate;
    private final LocalDate toDate;       // due date
    private LocalDate returnDate;          // null until the book is actually returned
    private BookingStatus status;

    public Booking(String id, Book book, User user, LocalDate fromDate, LocalDate toDate) {
        this.id = id;
        this.book = book;
        this.user = user;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.status = BookingStatus.ACTIVE;
    }

    public void markReturned(LocalDate returnDate) {
        this.returnDate = returnDate;
        this.status = BookingStatus.RETURNED;
    }

    public String getId() { return id; }
    public Book getBook() { return book; }
    public User getUser() { return user; }
    public LocalDate getFromDate() { return fromDate; }
    public LocalDate getToDate() { return toDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public BookingStatus getStatus() { return status; }

    @Override
    public String toString() {
        return "Booking{id='" + id + "', book='" + book.getName() + "', user='" + user.getName()
                + "', from=" + fromDate + ", to=" + toDate + ", status=" + status + "}";
    }
}

