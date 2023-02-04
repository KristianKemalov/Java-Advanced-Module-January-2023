package StacksAndQueues;

import com.sun.source.tree.IfTree;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> history = new ArrayDeque<>();

        String currentInput = sc.nextLine();


        while (!currentInput.equals("Home")) {

            if (currentInput.equals("back")) {
                if (history.isEmpty() || history.size() == 1) {
                    System.out.println("no previous URLs");
                    currentInput = sc.nextLine();
                    continue;
                } else {
                    history.pop();
                }

            } else {
                history.push(currentInput);

            }
            System.out.println(history.peek());


            currentInput = sc.nextLine();
        }

    }
}
