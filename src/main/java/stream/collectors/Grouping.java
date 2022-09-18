package stream.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;

public class Grouping {
    public static void run() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Thomas", 28, 1.85));
        people.add(new Person("John", 37, 2.05));
        people.add(new Person("Julia", 52, 1.68));

        List<String> teams = new ArrayList<>();

        teams.add("Poland");
        teams.add("Slovakia");
        teams.add("Spain");
        teams.add("Sweden");

        Map<Integer, List<Person>> groupingByAge = people.stream()
                .collect(groupingBy(Person::getAge));

        System.out.println(groupingByAge);
        System.out.println();

        Map<Integer, List<String>> groupingByStringLength = teams.stream()
                .collect(groupingBy(String::length));

        System.out.println(groupingByStringLength);
        System.out.println();

        Map<Boolean, List<String>> partitioningByFirstLetter = teams.stream()
                .collect(partitioningBy(team -> team.startsWith("S")));

        System.out.println(partitioningByFirstLetter);
        System.out.println();

        Map<Boolean, List<Person>> partitioningByAge = people.stream()
                .collect(partitioningBy(person -> person.getAge() > 30));

        System.out.println(partitioningByAge);
    }
}
