package SetsAndMaps;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<Double, Integer> occurrences = new LinkedHashMap<>();


        String[] numbers = sc.nextLine().split(" ");
        for (String num : numbers) {
            double current = Double.parseDouble(num);
            if (occurrences.containsKey(current)) {
                Integer count = occurrences.get(current);
                occurrences.put(current, count + 1);
            } else {
                occurrences.put(current, 1);
            }
        }

        for (Double num : occurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", num, occurrences.get(num));


        }
    }
}
