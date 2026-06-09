package random;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

/**
 * ============================================================
 *         LAMBDA FUNCTIONS & STREAMS — COMPLETE GUIDE
 * ============================================================
 *
 * WHAT IS A LAMBDA?
 * A lambda is an anonymous (nameless) function that can be
 * passed around as a value. Think of it as a sticky note with
 * instructions — you write the instruction once and hand it
 * to whoever needs it.
 *
 * SYNTAX:
 *   (parameters) -> expression
 *
 * WHAT IS A STREAM?
 * A Stream is like a conveyor belt in a factory:
 *  - The LIST is the raw material loaded onto the belt.
 *  - INTERMEDIATE operations (filter, map, sorted...) are
 *    machines on the belt that transform items.
 *  - TERMINAL operations (forEach, collect, reduce...) are
 *    the final packaging step.
 *  - LAMBDAS are the instructions given to each machine.
 *
 * ============================================================
 */
public class LambdaAndStreamsGuide {

    public static void main(String[] args) {

        // ====================================================
        // SECTION 1 — CORE FUNCTIONAL INTERFACES
        // ====================================================
        //
        // Java provides built-in functional interfaces in
        // java.util.function package:
        //
        //  Interface              Method       Use
        //  ---------------------  -----------  -------------------------
        //  Function<T,R>          .apply()     input → output
        //  BiFunction<T,U,R>      .apply()     two inputs → output
        //  Predicate<T>           .test()      input → boolean
        //  Consumer<T>            .accept()    input → no output
        //  Supplier<T>            .get()       no input → output
        //  UnaryOperator<T>       .apply()     same type in & out
        //  BinaryOperator<T>      .apply()     two same types → same type
        //
        // ====================================================


        // ----------------------------------------------------
        // Q1 — Function<T,R>: Square of a number
        // ----------------------------------------------------
        // Write a lambda that takes a number and returns its
        // square. Test with 7, 12, and 25.
        //
        // OUTPUT:
        //   Square of 7  = 49
        //   Square of 12 = 144
        //   Square of 25 = 625
        // ----------------------------------------------------

        Function<Integer, Integer> square = x -> x * x;

        System.out.println("=== Q1: Square of a Number ===");
        System.out.println("Square of 7  = " + square.apply(7));
        System.out.println("Square of 12 = " + square.apply(12));
        System.out.println("Square of 25 = " + square.apply(25));
        System.out.println();


        // ----------------------------------------------------
        // Q2 — BiFunction<T,U,R>: Greater of two numbers
        // ----------------------------------------------------
        // Write a lambda using BiFunction that takes two
        // integers and returns the greater one (no Math.max).
        //
        // OUTPUT:
        //   45
        //   99
        //   7
        // ----------------------------------------------------

        BiFunction<Integer, Integer, Integer> greater = (x, y) -> x >= y ? x : y;

        System.out.println("=== Q2: Greater of Two Numbers ===");
        System.out.println(greater.apply(10, 45));
        System.out.println(greater.apply(99, 3));
        System.out.println(greater.apply(7, 7));
        System.out.println();


        // ----------------------------------------------------
        // Q3 — Predicate<T>: Starts with capital letter
        // ----------------------------------------------------
        // Write a lambda using Predicate that checks whether
        // a given string starts with a capital letter.
        //
        // NOTE: The defensive !str.isEmpty() check prevents
        // a StringIndexOutOfBoundsException on empty strings.
        // The && short-circuits — if isEmpty() is true, the
        // second condition never runs.
        //
        // OUTPUT:
        //   true
        //   false
        //   true
        //   false
        // ----------------------------------------------------

        Predicate<String> startsWithCapital =
                str -> !str.isEmpty() && Character.isUpperCase(str.charAt(0));

        System.out.println("=== Q3: Starts With Capital Letter ===");
        System.out.println(startsWithCapital.test("Hello"));
        System.out.println(startsWithCapital.test("world"));
        System.out.println(startsWithCapital.test("Java"));
        System.out.println(startsWithCapital.test("lambda"));
        System.out.println();


        // ----------------------------------------------------
        // Q4 — Consumer<T>: Print formatted string
        // ----------------------------------------------------
        // Write a lambda using Consumer that takes a string
        // and prints it in the format: >> HELLO <<
        // (uppercase, with >> prefix and << suffix)
        //
        // Consumer returns nothing — it just performs a
        // side effect (printing, logging, saving, etc.)
        //
        // OUTPUT:
        //   >> HELLO <<
        //   >> JAVA <<
        //   >> LAMBDA <<
        // ----------------------------------------------------

        Consumer<String> printer =
                str -> System.out.println(">> " + str.toUpperCase() + " <<");

        System.out.println("=== Q4: Formatted Printer (Consumer) ===");
        printer.accept("hello");
        printer.accept("java");
        printer.accept("lambda");
        System.out.println();


        // ====================================================
        // SECTION 2 — STREAMS WITH LAMBDAS
        // ====================================================
        //
        // Stream operations:
        //
        //  Operation          Type           What it does
        //  -----------------  -------------- ----------------------
        //  .filter(pred)      intermediate   keeps matching items
        //  .map(function)     intermediate   transforms each item
        //  .flatMap(fn)       intermediate   flattens nested streams
        //  .sorted(comp)      intermediate   sorts items
        //  .distinct()        intermediate   removes duplicates
        //  .limit(n)          intermediate   takes first n items
        //  .forEach(consumer) terminal       action on each item
        //  .collect(coll)     terminal       gathers into list/set/map
        //  .reduce(operator)  terminal       collapses to single value
        //  .count()           terminal       counts items
        //  .anyMatch(pred)    terminal       returns boolean
        //
        // ====================================================


        // ----------------------------------------------------
        // Q5 — filter() + forEach(): Names longer than 4 chars
        // ----------------------------------------------------
        // Filter out names that have more than 4 characters
        // and print them.
        //
        // NOTE: System.out::println is a method reference,
        // shorthand for name -> System.out.println(name)
        //
        // OUTPUT:
        //   Alice
        //   Charlie
        //   Diana
        // ----------------------------------------------------

        List<String> names = List.of("Bob", "Alice", "Tom", "Charlie", "Sam", "Diana");

        System.out.println("=== Q5: Names Longer Than 4 Characters ===");
        names.stream()
                .filter(name -> name.length() > 4)
                .forEach(System.out::println);
        System.out.println();


        // ----------------------------------------------------
        // Q6 — map() + forEach(): USD to INR conversion
        // ----------------------------------------------------
        // Convert each price from USD to INR (1 USD = 83 INR)
        // and print the converted values.
        //
        // KEY LESSON: Use .map() for transformation, keep
        // .forEach() only for the final action (printing).
        // Mixing transformation into forEach() prevents
        // chaining further operations on transformed values.
        //
        // OUTPUT:
        //   415
        //   830
        //   1660
        //   4150
        //   8300
        // ----------------------------------------------------

        List<Integer> usdPrices = List.of(5, 10, 20, 50, 100);

        System.out.println("=== Q6: USD to INR Conversion ===");
        usdPrices.stream()
                .map(x -> x * 83)
                .forEach(System.out::println);
        System.out.println();


        // ----------------------------------------------------
        // Q7 — map() + filter() chaining: Uppercase + filter
        // ----------------------------------------------------
        // Convert each word to uppercase, then filter and
        // print only those that start with 'S'.
        //
        // ORDER MATTERS: map() first (so filter works on
        // uppercase), then filter(). If reversed, you'd need
        // to check for lowercase 's' and the result wouldn't
        // be uppercase.
        //
        // TIP: str -> str.toUpperCase() can be written as
        // the method reference String::toUpperCase
        //
        // OUTPUT:
        //   SKY
        //   SUN
        //   STAR
        //   SATURN
        // ----------------------------------------------------

        List<String> words = List.of("sky", "sun", "moon", "star", "earth", "saturn");

        System.out.println("=== Q7: Uppercase Words Starting With S ===");
        words.stream()
                .map(String::toUpperCase)          // method reference
                .filter(str -> str.startsWith("S"))
                .forEach(System.out::println);
        System.out.println();


        // ----------------------------------------------------
        // Q8 — filter() + collect(): Collect odd numbers
        // ----------------------------------------------------
        // Filter only the odd numbers and collect them into
        // a new list, then print that list.
        //
        // .collect(Collectors.toList()) gathers stream results
        // back into a List — use when you need to store or
        // pass the result further, not just print it.
        //
        // OUTPUT:
        //   [1, 3, 5, 7, 9]
        // ----------------------------------------------------

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("=== Q8: Collect Odd Numbers Into a List ===");
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());
        System.out.println(oddNumbers);
        System.out.println();


        // ----------------------------------------------------
        // Q9 — flatMap(): Flatten sentences into words
        // ----------------------------------------------------
        // WHAT IS flatMap()?
        // When .map() would produce a Stream<Stream<R>>,
        // use flatMap() to collapse it into Stream<R>.
        //
        // ANALOGY: You ordered groceries from 5 shops.
        // Each shop delivers in its own bag (nested lists).
        //  .map()     = tag each bag. Still 5 separate bags.
        //  .flatMap() = empty all bags onto one table.
        //               One flat pile of all items.
        //
        // String.split(" ") returns a String[].
        // Arrays.stream() converts that array into a Stream.
        // flatMap() then merges all those streams into one.
        //
        // OUTPUT:
        //   Java
        //   is
        //   fun
        //   Lambdas
        //   are
        //   powerful
        //   Streams
        //   make
        //   life
        //   easy
        // ----------------------------------------------------

        List<String> sentences = List.of(
                "Java is fun",
                "Lambdas are powerful",
                "Streams make life easy"
        );

        System.out.println("=== Q9: flatMap() — Sentences to Words ===");
        sentences.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .forEach(System.out::println);
        System.out.println();

    }
}