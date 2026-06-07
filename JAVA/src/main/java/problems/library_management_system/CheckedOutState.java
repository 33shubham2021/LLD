package problems.library_management_system;

public class CheckedOutState implements BookState {

    @Override
    public void allocate(Book book, User user) {
        // Book is unavailable — register the requester as an observer instead.
        // This is the Observer hook: the user gets notified the moment it's returned.
        System.out.println("\"" + book.getName() + "\" is currently checked out.");
        book.addObserver(user);
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("Returning \"" + book.getName() + "\"");
        book.setState(new AvailableState());
        // Notify the next user in the reservation queue, if any
        book.notifyObservers();
    }
}