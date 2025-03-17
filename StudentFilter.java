import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    int marks;

    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " - Marks: " + marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 80),
            new Student("Bob", 70),
            new Student("Charlie", 90),
            new Student("David", 65)
        );

        List<Student> filteredStudents = students.stream()
            .filter(s -> s.marks > 75)
            .sorted((s1, s2) -> Integer.compare(s2.marks, s1.marks))
            .collect(Collectors.toList());

        System.out.println("Students scoring above 75% sorted by marks:");
        filteredStudents.forEach(System.out::println);
    }
}