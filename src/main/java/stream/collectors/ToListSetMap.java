package stream.collectors;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

public class ToListSetMap {
    public static void run() {
        List<String> teams = new ArrayList<>();

        teams.add("Poland");
        teams.add("Slovakia");
        teams.add("Spain");
        teams.add("Sweden");

        List<String> teamsStartingWithS = teams.stream()
                .filter(team -> team.startsWith("S"))
                .collect(toList());

        System.out.println(teamsStartingWithS);

        Set<String> setOfTeamsStartingWithS = teams.stream()
                .filter(team -> team.startsWith("S"))
                .collect(toSet());

        System.out.println(setOfTeamsStartingWithS);

       Country country = new Country("Poland", "Warsaw");
       Country country1 = new Country("Spain", "Madrid");
       Country country2 = new Country("Slovakia", "Bratislava");
       Country country3 = new Country("Sweden", "Stockholm");

       List<Country> countries = new ArrayList<>();

       countries.add(country);
       countries.add(country1);
       countries.add(country2);
       countries.add(country3);

        Map<String, String> countriesMap = countries.stream()
                .filter(c -> country.getName().startsWith("S"))
                .collect(toMap(Country::getName, Country::getCapital));

        System.out.println(countriesMap);
    }
}
