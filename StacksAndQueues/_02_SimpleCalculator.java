package StacksAndQueues;

import java.util.*;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();

        String expression = sc.nextLine();
        String[] expressionsParts = expression.split(" ");
        List<String> partsList = Arrays.asList(expressionsParts);
        Collections.reverse(partsList);

        for (String item : partsList) {
            stack.push(item);
        }

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int second = Integer.parseInt(stack.pop());
            int result = 0;

            switch (op) {
                case "+":
                    result = first + second;
                    break;
                case "-":
                    result = first - second;
                    break;

            }
            stack.push("" + result);
        }
        System.out.println(stack.peek());
    }
}
