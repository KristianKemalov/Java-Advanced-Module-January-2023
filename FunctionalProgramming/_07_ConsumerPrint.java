package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class _07_ConsumerPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String input = sc.nextLine();

        String[] names = input.split(" ");

        Consumer<String> printName = name -> System.out.println(name);


        for (String name : names) {
            printName.accept(name);
        }


    }
}
