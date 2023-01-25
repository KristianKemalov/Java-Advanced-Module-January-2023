package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(", "))
                .map(elem -> Integer.parseInt(elem))
                .collect(Collectors.toList());


        numbers.removeIf(elem -> elem % 2 != 0);
        print(numbers);
        System.out.println();


        List<Integer> sortedNums = numbers.stream().sorted().collect(Collectors.toList());
        print(sortedNums);
    }

    private static void print(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));

            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }

    }

}
