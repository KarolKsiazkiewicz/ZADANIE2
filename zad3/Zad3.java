import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class Zad3 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Anna Kowalska", "IT", 8000.00),
            new Employee("Jan Nowak", "IT", 7500.00),
            new Employee("Maria Wiśniewska", "HR", 4500.00),
            new Employee("Piotr Zieliński", "IT", 9000.00),
            new Employee("Katarzyna Lewandowska", "HR", 4800.00),
            new Employee("Tomasz Kamiński", "Sprzedaż", 5500.00),
            new Employee("Agnieszka Wójcik", "Sprzedaż", 6000.00),
            new Employee("Michał Kowalczyk", "IT", 8500.00),
            new Employee("Ewa Szymańska", "HR", 5000.00),
            new Employee("Paweł Dąbrowski", "Sprzedaż", 5800.00),
            new Employee("Magdalena Król", "Marketing", 6500.00),
            new Employee("Krzysztof Piotrowski", "Marketing", 7000.00),
            new Employee("Joanna Grabowska", "HR", 4200.00),
            new Employee("Adam Pawlak", "Sprzedaż", 6200.00)
        );

        Map<String, Double> departmentAverages = employees.stream()
           .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.collectingAndThen(
                    Collectors.averagingDouble(Employee::getSalary),
                    avg -> BigDecimal.valueOf(avg)
                           .setScale(2, RoundingMode.HALF_UP)
                           .doubleValue()
                )
            ));

        Map<String, Double> result = departmentAverages.entrySet().stream()
           .filter(entry -> entry.getValue() > 5000.00)
           .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Zadanie 3 - Wynik: " + result);
    }
}
