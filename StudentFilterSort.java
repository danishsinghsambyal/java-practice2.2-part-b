import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilterSort {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Arnav", 82),
                new Student("Priya", 68),
                new Student("Rohan", 90),
                new Student("Simran", 74),
                new Student("Kabir", 95)
        );

        System.out.println("Students scoring > 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)  // filter students
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks)) // sort ascending
                .map(s -> s.name + " (" + s.marks + ")") // extract name + marks
                .forEach(System.out::println);
    }
}
