package problems.library_management_system;

import java.util.List;

/**
 * STRATEGY PATTERN — pluggable search algorithms.
 * Library delegates search to whichever strategy is configured,
 * without caring how the search is actually performed.
 */
public interface SearchStrategy {
    List<Book> search(List<Book> books, String query);
}
