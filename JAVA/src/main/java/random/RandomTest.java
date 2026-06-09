package random;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class RandomTest {
    public static void main(String[] args) {
        List<String> sentences = List.of(
                "Java is fun",
                "Lambdas are powerful",
                "Streams make life easy"
        );

        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .forEach(System.out::println);


    }

}
