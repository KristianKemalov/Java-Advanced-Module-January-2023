package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _13_MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String command = sc.nextLine();

            String[] parts = command.split("\\s+");
            String commandType = parts[0];

            if (commandType.equals("1")) {
                int num = Integer.parseInt(parts[1]);
                stack.push(num);
            } else if (commandType.equals("2")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (commandType.equals("3")) {
                System.out.println(Collections.max(stack));
            }


        }
    }
}
