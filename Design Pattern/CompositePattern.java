import java.util.*;

// Component
class Employee {
    private String name;
    private List<Employee> subordinates = new ArrayList<>();

    public Employee(String name) {
        this.name = name;
    }

    // Add subordinate
    public void add(Employee e) {
        subordinates.add(e);
    }

    // Display structure
    public void show() {
        System.out.println(name);
        for (Employee e : subordinates) {
            e.show();
        }
    }
}

// Main Class
public class CompositePattern {
    public static void main(String[] args) {

        Employee manager = new Employee("Manager");

        Employee emp1 = new Employee("Employee 1");
        Employee emp2 = new Employee("Employee 2");

        manager.add(emp1);
        manager.add(emp2);

        manager.show();
    }
}