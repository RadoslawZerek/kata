package stream.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.summingInt;

public class CountingSummingAveraging {
    public static void run() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Thomas", 28, 1.85));
        people.add(new Person("John", 37, 2.05));
        people.add(new Person("Julia", 52, 1.68));

        Long collect = people.stream()
                .collect(counting());

        System.out.println(collect);

        Integer summingAge = people.stream()
                .collect(summingInt(Person::getAge));

        System.out.println(summingAge);

        Double summingHeight = people.stream()
                .collect(summingDouble(Person::getHeight));

        System.out.println(summingHeight);

        Double averagingAge = people.stream()
                .collect(averagingInt(Person::getAge));

        System.out.println(averagingAge);

        Double averagingHeight = people.stream()
                .collect(averagingDouble(Person::getHeight));

        System.out.println(averagingHeight);

        Optional<Integer> maxAge = people.stream()
                .map(Person::getAge).max(naturalOrder());

        System.out.println(maxAge.get());

        Optional<Integer> minAge = people.stream()
                .map(Person::getAge).min(naturalOrder());

        System.out.println(minAge.get());
    }
}
