package stream.collectors;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Summarizing {
    public static void run() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Thomas", 28, 1.85));
        people.add(new Person("John", 37, 2.05));
        people.add(new Person("Julia", 52, 1.68));

        IntSummaryStatistics collect = people.stream()
                .collect(Collectors.summarizingInt(Person::getAge));

        System.out.println(collect);

        DoubleSummaryStatistics collect1 = people.stream()
                .collect(Collectors.summarizingDouble(Person::getHeight));

        System.out.println(collect1);
    }
}
