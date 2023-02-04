package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class _14_ListOfPredicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = (number, list) -> {
            for (int num : list) {
                if (number % num != 0) {
                    return false;
                }
            }
            return true;

        };

        for (int i = 1; i <= n; i++) {
            if (isDivisible.apply(i,numbers)){
                System.out.print(i+" ");
            }

        }
    }
}
