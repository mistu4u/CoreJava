package test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {
    // Complete the braces function below.
    static String[] braces(String[] values) {
        HashMap<Character, Character> matches = new HashMap<>();
        matches.put('{', '}');
        matches.put('(', ')');
        matches.put('[', ']');
        List<String> resultString = new ArrayList<>();
        for (String element : values) {
            System.out.println(element);

            Set<Character> specialChars = new HashSet<>();
            Deque<Character> expected = new LinkedList<>();
            for (Map.Entry<Character, Character> ee : matches.entrySet()) {
                specialChars.add(ee.getKey());
                specialChars.add(ee.getValue());
            }

            for (int i = 1; i < element.length(); i++) {
                char next = element.charAt(i);
                Character expect = expected.peekLast();
                if (expect != null && expect == next) {
                    expected.removeLast();
                } else if (matches.containsKey(next)) {
                    expected.addLast(matches.get(next));
                } else if (specialChars.contains(next)) {
                    resultString.add("NO");
                }
            }
            resultString.add("YES");

        }
//        resultString.remove(resultString.size()-1);
        String[] array = resultString.toArray(new String[resultString.size()]);
        return array;
    }

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\work\\rei\\a.txt"));

        int valuesCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] values = new String[valuesCount];

        for (int i = 0; i < valuesCount; i++) {
            String valuesItem = scanner.nextLine();
            values[i] = valuesItem;
        }

        String[] res = braces(values);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(res[i]);

            if (i != res.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
