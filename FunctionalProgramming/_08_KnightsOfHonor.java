package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class _08_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] names = sc.nextLine().split(" ");

        Consumer<String> printName = string -> System.out.println("Sir " + string);

        Arrays.stream(names).forEach(printName);

    }
}
