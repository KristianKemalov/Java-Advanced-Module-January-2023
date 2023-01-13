package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class _12_Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] parts = (input.split(" "));

        for (String num : parts) {
            stack.push(num);

        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop()+" ");
        }
    }
}
