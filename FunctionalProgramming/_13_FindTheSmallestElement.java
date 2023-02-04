package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _13_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> printLastIndexOfMinElem = list -> {
            int minElement = Collections.min(numbers);
            System.out.println(list.lastIndexOf(minElement));
        };

        printLastIndexOfMinElem.accept(numbers);
    }
}