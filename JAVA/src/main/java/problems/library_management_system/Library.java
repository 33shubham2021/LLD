package problems.library_management_system;

import problems.library_management_system.strategies.BookFindingStrategy;

import java.util.List;

public class Library {

    private List<Book> booklist;

    public boolean addBook(Book book){
        return true;
    }

    public boolean deleteBook(Book book){
        return true;
    }

    public Book findBook(BookFindingStrategy bookFindStrategy){
        return null;
    }

    public int getAmount(Booking booking){
        return 0;
    }

    public List<Book> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<Book> booklist) {
        this.booklist = booklist;
    }
}
