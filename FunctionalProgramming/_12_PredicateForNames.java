package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class _12_PredicateForNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] names = sc.nextLine().split(" ");

        Predicate<String> checkLength = name -> name.length() <= n;


        Arrays.stream(names).filter(checkLength).forEach(System.out::println);
    }
}
