package stream.collectors;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Joining {
    public static void run() {
        List<String> names = new ArrayList<>();

        names.add("John");
        names.add("Thomas");
        names.add("Julia");

        String joined = names.stream()
                .collect(joining(" ", "Names: ", " :)"));

        System.out.println(joined);
    }
}
