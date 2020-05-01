package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapOfSet {
    static void initiate(Map<String, Set<String>> mapToTest) {
        Set<String> value = new HashSet<>(Arrays.asList("a", "b", "c"));
        mapToTest.put("key", value);
    }

    static void print(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        Map<String, Set<String>> mapToTest = new HashMap<>();
        initiate(mapToTest);
/*        System.out.println(mapToTest.values());
        for (Set<String> strings : mapToTest.values()) {
            strings.stream().forEach(
                    item-> System.out.println(item)
            );
        }*/
        Set<String> newset = new HashSet<>();
        mapToTest.values().forEach(value -> value.forEach(value1 -> System.out.println(value1)));
        newset = mapToTest.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
        newset.forEach(valie -> System.out.println(valie));
        List<Map<String,String>> newList = new ArrayList<>();
        Map<String,String> hashMap1 = new HashMap<>();
        Map<String,String> hashMap2 = new HashMap<>();
        hashMap1.put("subir","tu");
        hashMap1.put("abhi","test");
        newList.add(hashMap1);
        newList.add(hashMap2);
                 newList.stream()
                .collect(HashMap::new, HashMap::putAll, HashMap::putAll)
                .entrySet();
    }
}
