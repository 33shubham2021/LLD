package problems.library_management_system;

import java.util.List;
import java.util.stream.Collectors;

public class SearchByCategory implements SearchStrategy {
    @Override
    public List<Book> search(List<Book> books, String query) {
        try {
            Category category = Category.valueOf(query.toUpperCase());
            return books.stream()
                    .filter(b -> b.getCategory() == category)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            return List.of(); // unknown category — empty result rather than a crash
        }
    }
}