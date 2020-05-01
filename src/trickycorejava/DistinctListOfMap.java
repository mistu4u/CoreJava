package trickycorejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctListOfMap {
    public static void main(String[] args) {
/*        List<Map<String, String>> listOfMap = new ArrayList<>();
        listOfMap.add(Collections.singletonMap("Name", "Subir"));
        listOfMap.add(Collections.singletonMap("Name", "Nutu"));
        listOfMap.add(Collections.singletonMap("Name", "Nutu"));

        Set<String> name = listOfMap.stream().map(map -> map.get("Name")).collect(Collectors.toSet());
        System.out.println("distinct names are " + name); */

        List<List<String>> aList = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        /*List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();
        a.addAll(Arrays.asList("Wrangler", "Tommy"));
        b.addAll(Arrays.asList("SS20", "FW20")); */
        aList.add(Arrays.asList("Wrangler","Tommy"));
        aList.add(Arrays.asList("SS20","FW20"));
        aList.add(Arrays.asList("A","B"));
//        listTraverse(aList);
        for(int i =0;i<aList.size()-1;i++) {
            result.add(listTra(aList.get(i), aList.get(i+1)));
        }
        System.out.println("result = "+result);
    }

    private static List<String> listTra(List<String> a, List<String> b) {
        List<String> ofList = new ArrayList<>();
        for (int j = 0; j < a.size(); j++) { //Each element of list 1
            for (int k = 0; k < b.size(); k++) { //each element of list 2
                System.out.println(" j= " + j + " k= " + k + " values ->"
                        + a.get(j) + ", " + b.get(k));
                ofList.add(a.get(j));
                ofList.add(b.get(k));
            }
        }
        return ofList;
    }

//    private static void listTraverse(List<List<String>> aList) {
//        for(int i =0;i<aList.size();i++){ //Each list of the outer list
//            for(int j=0;j<aList.get(i).size();j++){ //Each element of list 1
//                for(int k=0;k<aList.get(j+1).size();k++){ //each element of list 2
//                    System.out.println("i= "+i+" j= "+j+ " k= "+k + " values ->"
//                            +aList.get(j).get(j) + ", " + aList.get(j+1).get(k));
//                }
//            }
//        }
//    }


}
