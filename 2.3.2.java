import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " | Marks: " + marks;
    }
}

public class FilterSortStudents {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Riya", 82.5),
            new Student("Aman", 65.0),
            new Student("Neha", 91.2),
            new Student("Vikas", 74.0),
            new Student("Kiran", 88.7)
        );

        System.out.println("All Students:");
        students.forEach(System.out::println);

        System.out.println("\nStudents scoring above 75%, sorted by marks:");
        students.stream()
                .filter(s -> s.marks > 75)
                .sorted((s1, s2) -> Double.compare(s1.marks, s2.marks))
                .map(s -> s.name)
                .forEach(System.out::println);
    }
}
