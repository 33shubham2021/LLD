package regex;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String input = "TIMESTAMP: 2024-02-14 10:30";

        // This regex has multiple parts/groups
        String regex = "(\\d{4})-(\\d{2})-(\\d{2}) (\\d{2}:\\d{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            System.out.println("--- Raw Match Data ---");
            // group(0) is always the FULL text that matched the pattern
            System.out.println("Full Match [group(0)]: " + matcher.group(0));

            System.out.println("\n--- Extracted Parts ---");
            // Extracting by index based on the order of opening parentheses (
            System.out.println("Year       [group(1)]: " + matcher.group(1));
            System.out.println("Month      [group(2)]: " + matcher.group(2));
            System.out.println("Day        [group(3)]: " + matcher.group(3));
            System.out.println("Time       [group(4)]: " + matcher.group(4));

            // You can also get the total number of groups found
            System.out.println("\nTotal groups: " + matcher.groupCount());
        } else {
            System.out.println("No match found!");
        }

        System.out.println("--- Working with just one group ---");
        String text = "Hello, Alice! and Hello, Bob!";
        String patternText = "Hello, (\\w+)!";
        //he stuff outside the parentheses (Hello, and !) is used to find
        // the right spot, but only the stuff inside (...) is stored in group(1)
        Pattern pattern2 = Pattern.compile(patternText);
        Matcher m2 = pattern2.matcher(text);
        while (m2.find()) {
            System.out.println("Full Match: " + m2.group(0));

            // group(1) is ONLY what was inside the first set of parentheses
            System.out.println("Extracted Name: " + m2.group(1));
        }

    }
}
