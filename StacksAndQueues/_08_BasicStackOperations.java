package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _10_BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int x = sc.nextInt();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            stack.push(sc.nextInt());
        }
        for (int i = 1; i <= s; i++) {
            stack.pop();

        }
        if (stack.contains(x)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                System.out.println(Collections.min(stack));
            }
        }

    }

}
