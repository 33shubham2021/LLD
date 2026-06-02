package comparable_and_comparator;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Car> listOfCars = new ArrayList<>();
        listOfCars.add(new Car("BMW", 2000));
        listOfCars.add(new Car("Mercedes", 3000));
        listOfCars.add(new Car("Audi", 2500));
        listOfCars.add(new Car("Alto", 300));

        // Sorting using comparable interface (implicit comparison)
        Collections.sort(listOfCars);
        for (Car car : listOfCars) {
            System.out.println("Brand: " + car.brand + " Price: " + car.price);
        }

        System.out.println("------------------------------");

        List<Student> students = Arrays.asList(
                new Student(64, 560, "Shubham"),
                new Student(36, 480, "Shaivalini"),
                new Student(72, 280, "John Doe"),
                new Student(92, 770, "Alex"),
                new Student(14, 682, "Bruce Lee")
        );

        // Creating comparator based on marks
        Comparator<Student> marksComparator = (s1, s2) -> s2.marks - s1.marks;

        // Passing the above comparator to sorting method
        Collections.sort(students, marksComparator);
        for (Student student : students) {
            System.out.println("Marks: " + student.marks + " Name: " + student.name);
        }

        System.out.println("--------------STREAMS----------------");
        Stream<Student> studentStream = students.stream();
        List<Student> greaterMarksStudents = studentStream.filter((s) -> s.marks >= 500).toList();
        System.out.println("Printing students having marks >= 500");
        for (Student student : greaterMarksStudents) {
            System.out.println("Marks: " + student.marks + " Name: " + student.name);
        }

        // Comparator on the basis of rollNumber
        Comparator<Student> rollNumberComparator = (s1, s2) -> s1.rollNumber - s2.rollNumber;
        Collections.sort(students, rollNumberComparator);
        for (Student student : students) {
            System.out.println("Roll Number: " + student.rollNumber + " Name: " + student.name);
        }

    }
}
