import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " - Age: " + age + ", Salary: " + salary;
    }
}

public class EmployeeSort {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 25, 50000),
            new Employee("Bob", 30, 70000),
            new Employee("Charlie", 28, 60000)
        );

        employees.sort((e1, e2) -> Double.compare(e1.salary, e2.salary));

        System.out.println("Employees sorted by salary:");
        employees.forEach(System.out::println);
    }
}