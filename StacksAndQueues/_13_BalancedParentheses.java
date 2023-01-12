package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _13_BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String input = sc.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean areBalanced = false;

        for (char bracket : input.toCharArray()) {

            if (bracket == '[' || bracket == '{' || bracket == '(') {
                stack.push(bracket);
            } else if (bracket == ']' || bracket == '}' || bracket == ')') {
                if (stack.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = stack.pop();

                if (lastOpenBracket == '(' && bracket == ')') {
                    areBalanced = true;

                } else if (lastOpenBracket == '[' && bracket == ']') {
                    areBalanced = true;

                } else if (lastOpenBracket == '{' && bracket == '}') {
                    areBalanced = true;

                } else {
                    areBalanced = false;
                    break;
                }
            }

        }
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
