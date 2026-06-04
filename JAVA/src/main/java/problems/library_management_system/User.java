package problems.library_management_system;

import problems.library_management_system.enums.ActivationStatus;

import java.util.List;

public class User {
    private int userId;
    private String name;
    private String email;
    private String phoneNumber;
    private ActivationStatus status;
    private List<Booking> bookingList;
    private Library library;

    public void assignBook(Booking booking){
        // process the observers here
        // change the status
        String bookId = booking.getBookId();
        String userId = booking.getUserId();


    }

    public void returnBook(Booking booking){
        this.bookingList.remove(booking);
        // process the observers here
        // change the status
        // calculate the amount

    }

}
