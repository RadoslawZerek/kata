package stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

    List<Employee> employees = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("John", "Doe", 37, List.of("Java", "JavaScript", "Python"));
        Employee employee2 = new Employee("Tony", "Barret", 18, List.of("C++", "React", "Python"));
        Employee employee3 = new Employee("Lidia", "Smith", 28, List.of("Python", "C#", "Delphi"));
        Employee employee4 = new Employee("Tom", "Clancy", 30, List.of("Java", "React", "NodeJS"));
        Employee employee5 = new Employee("Ralph", "Oldman", 54, List.of("Java", "Scala", "Bash"));
        Employee employee6 = new Employee("Terrence", "Gaver", 42, List.of("JavaScript", "HTML", "CSS"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
    }

    @Test
    public void firstStream() {
        employees.forEach(System.out::println);
    }

    @Test
    public void mapOperation() {
        employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .forEach(System.out::println);
    }

    @Test
    public void flatMapOperation() {
        List<List<String>> allSkills = employees.stream()
                .map(Employee::getSkills)
                .collect(Collectors.toList());

        System.out.println(allSkills);

        List<String> allSkills2 = employees.stream()
                .map(Employee::getSkills)
                .flatMap(list -> list.stream())
                .distinct()                //Deleted duplicated values
                .collect(Collectors.toList());

        System.out.println(allSkills2);
    }

    @Test
    public void filterOperation() {
        employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("T"))
                .forEach(System.out::println);
    }

    @Test
    public void sortedOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);
    }

    @Test
    public void limitOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void skipOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void countOperation() {
        long numberOfEmployees = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("T"))
                .count();

        System.out.println(numberOfEmployees);
    }

    @Test
    public void minMaxOperations() {
        Employee youngestEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getAge)).get();

        System.out.println(youngestEmployee);

        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getAge)).get();

        System.out.println(oldestEmployee);
    }

    @Test
    public void findAnyFindFirstOperations() {
        Employee employee1 = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("T"))
                .findFirst().get();

        System.out.println(employee1);

        Employee employee2 = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("T"))
                .findAny().get();

        System.out.println(employee2);
    }

    @Test
    public void matchOperations() {
        boolean b = employees.stream()
                .allMatch(employee -> employee.getFirstName().startsWith("T"));

        System.out.println(b);

        boolean c = employees.stream()
                .anyMatch(employee -> employee.getFirstName().startsWith("T"));

        System.out.println(c);

        boolean d = employees.stream()
                .noneMatch(employee -> employee.getFirstName().startsWith("X"));

        System.out.println(d);
    }

    @Test
    public void reduceOperation() {
        Integer sumOfAllAges = employees.stream()
                .map(Employee::getAge)
                .reduce(Integer::sum).get();

        System.out.println(sumOfAllAges);

        Integer sumOfAllAges2 = employees.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);

        System.out.println(sumOfAllAges2);

        Integer sumOfAllAges3 = employees.stream()
                .reduce(0, (age, employee) -> age + employee.getAge(), Integer::sum);

        System.out.println(sumOfAllAges3);

        String allNames = employees.stream()
                .map(Employee::getFirstName)
                .reduce((name, name2) -> name + ", " + name2).get();

        System.out.println(allNames);
    }

    @Test
    public void takeWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .takeWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);
    }

    @Test
    public void dropWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .dropWhile(employee -> employee.getAge() <= 30)
                .forEach(System.out::println);
    }

    @Test
    public void forEachOrderedOperation() {
        String sentence = "Stream's examples";

        sentence.chars().forEach(s -> System.out.print((char) s));
        System.out.println();
        sentence.chars().parallel().forEach(s -> System.out.print((char) s));
        System.out.println();
        sentence.chars().parallel().forEachOrdered(s -> System.out.print((char) s));
    }

    @Test
    public void peekOperation() {
    /*This method is unique because it allows you to modify elements of the original collection
    From official documentation: "This method exists mainly to support debugging"
    It should not be used in any other cases*/

        List<Employee> newNameForAllEmployees = employees.stream()
                .peek(employee -> employee.setFirstName("Alibaba"))
                .collect(Collectors.toList());

        System.out.println(newNameForAllEmployees);
        System.out.println();
        System.out.println("Original collection:");
        System.out.println(employees);
    }
}
