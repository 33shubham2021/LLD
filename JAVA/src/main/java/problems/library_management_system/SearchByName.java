package problems.library_management_system;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByName implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query) {
        return books.stream()
                .filter(b -> b.getName().equalsIgnoreCase(query))
                .collect(Collectors.toList());
    }
}
