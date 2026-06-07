package problems.library_management_system;

public class AvailableState implements BookState {

    @Override
    public void allocate(Book book, User user) {
        System.out.println("Allocating \"" + book.getName() + "\" to " + user.getName());
        book.setState(new CheckedOutState());
        // Library is responsible for creating the Booking record (see Library.allocateBook)
    }

    @Override
    public void returnBook(Book book) {
        // Cannot return a book that was never checked out
        System.out.println("\"" + book.getName() + "\" is already available — nothing to return.");
    }
}
