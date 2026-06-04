package problems.library_management_system.strategies;

import problems.library_management_system.Book;

public interface BookFindingStrategy {
    Book findBook(BookFindingStrategy bookFindStrategy);
}
