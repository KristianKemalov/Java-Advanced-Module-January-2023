package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;


public class _14_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        StringBuilder currentText = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {

            String command = sc.nextLine();


            if (command.startsWith("1")) {
                stack.push(currentText.toString());
                String textToAppend = command.split("\\s+")[1];
                currentText.append(textToAppend);

            } else if (command.startsWith("2")) {
                stack.push(currentText.toString());

                int count = Integer.parseInt(command.split("\\s+")[1]);
                int startIndexOfDelete = currentText.length() - count;
                currentText.delete(startIndexOfDelete, currentText.length());

            } else if (command.startsWith("3")) {
                int position = Integer.parseInt(command.split("\\s+")[1]);
                System.out.println(currentText.charAt(position - 1));
            } else if (command.equals("4")) {
                if (!stack.isEmpty()) {
                    currentText.delete(0, currentText.length());
                    currentText.append(stack.pop());
                }
            }

        }
    }
}
