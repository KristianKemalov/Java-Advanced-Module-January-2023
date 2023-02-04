package SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _10_SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);


        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            firstSet.add(Integer.parseInt(sc.nextLine()));
        }
        for (int i = 0; i < m; i++) {
            secondSet.add(Integer.parseInt(sc.nextLine()));

        }

        firstSet.retainAll(secondSet);
        firstSet.forEach(el -> System.out.print(el + " "));
    }
}
