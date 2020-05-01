package trickycorejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupListOfMap {
    public static void main(String[] args) throws InterruptedException {
        List<Map<String, String>> aList = new LinkedList<>();
        Map<String, String> mapOne = new LinkedHashMap<>();
        Map<String, String> mapTwo = new LinkedHashMap<>();
        mapOne.put("Name", "John");
        mapOne.put("Age", "30");
        mapOne.put("City", "Kolkata");
        mapTwo.put("Name", "Jack");
        mapTwo.put("Age", "31");
        mapTwo.put("City", "Kolkata");
        aList.add(mapOne);
        aList.add(mapTwo);
        List<String> fields = Arrays.asList("Age");
        List<String> countField = Arrays.asList("Age");
        List<String> listCols = Arrays.asList("Age","City");
        Map<List<String>, List<List<String>>> city = getListListMap(fields, aList, listCols);
        getSumOfAge(city, aList, countField);
        System.out.println(city);
        List<List<String>> abc = new ArrayList<>();
        abc.add(Arrays.asList("1","2"));
        abc.add(Arrays.asList("3","4","5"));
        System.out.println("count ->" +  abc.stream().mapToLong(Collection::size).sum());
        System.out.println("map two size ->" +  mapTwo.size());
    }

    private static void getSumOfAge(Map<List<String>, List<List<String>>> city
            , List<Map<String, String>> aList, List<String> countField) {
        System.out.println(aList.stream().collect(Collectors.groupingBy(map -> map.get(countField.get(0))
                , Collectors.counting())));
        System.out.println(countField.get(0) + " -> " + aList.stream().map(map -> Integer.parseInt(map.get(countField.get(0)))).reduce(0, Integer::sum));
    }

    private static Map<List<String>, List<List<String>>>
    getListListMap(List<String> fields, List<Map<String, String>> aList, List<String> listCols) {

        return aList.stream()
                .collect(Collectors.groupingBy(map ->
                                buildClassificationFunction(map, fields), //Call the function to build the list
                        Collectors.mapping(map1 -> listCols.stream().map(map1::get).collect(Collectors.toList())
                                , Collectors.toList())));
    }

    private static List<String> buildClassificationFunction(Map<String, String> map, List<String> fields) {
        return fields.stream()
                .map(map::get)
                .collect(Collectors.toList());
    }


}
