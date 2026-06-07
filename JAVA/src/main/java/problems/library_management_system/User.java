package problems.library_management_system;

import java.util.ArrayList;
import java.util.List;

public class User implements BookAvailabilityObserver {
    private final String userId;
    private final String name;
    private final String email;
    private final String phone;
    private UserStatus status;
    private final List<Booking> bookings = new ArrayList<>();

    public User(String userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.status = UserStatus.ACTIVE;
    }

    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public void onBookAvailable(Book book) {
        // In a real system this would push an email/SMS notification.
        System.out.println(">> [Notification to " + email + "]: \"" + book.getName()
                + "\" is now available for you to borrow, " + name + "!");
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public UserStatus getStatus() { return status; }
    public List<Booking> getBookings() { return bookings; }

    @Override
    public String toString() {
        return "User{id='" + userId + "', name='" + name + "', status=" + status + "}";
    }
}
