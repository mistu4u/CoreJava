package streams;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StreamsTest {
    public static void main(String[] args) {
        Person p1 = new Person("Subir", "Adhikari", 10);
        Person p2 = new Person("Abhi", "Karmakar", 10);
        Person p3 = new Person("Mainak", "Manna", 20);
        List<Person> people = Arrays.asList(p1, p2, p3);

        Comparator<Person> personComparator = (pOne, pTwo) -> {
            return pOne.getAge() - pTwo.getAge();
        };
        Map<Integer, List<Person>> duplicates = getDuplicates(people);
        System.out.println(duplicates);
        Map<String, Set<String>> foomap = new ConcurrentHashMap<>();
        Set<String> fooset = new HashSet<>();
        fooset.add("Subir");
        fooset.add("ADhikari");
        foomap.put("Sample", fooset);

        foomap.forEach((k, v) -> {

            v.stream().filter(f -> f.equalsIgnoreCase("Subir"))
                    .findFirst()
                    .ifPresent(p -> {
                        v.remove("Subir");
                    });

        });

        for (Map.Entry<String, Set<String>> entry : foomap.entrySet()) {

            for (String value : entry.getValue()) {

                if (value.equalsIgnoreCase("subir")) {
                    Set<String> value1 = entry.getValue();
                    value1.remove("Subir");
                    entry.setValue(value1);
                }
            }
        }
        System.out.println(foomap);
    }

    private static Map<Integer, List<Person>> getDuplicates(List<Person> people) {
        Map<Integer, List<Person>> collect = people.stream().collect(Collectors.groupingBy(Person::getAge));
        return collect;
    }
}
