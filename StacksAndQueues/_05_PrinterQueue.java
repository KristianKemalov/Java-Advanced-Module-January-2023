package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String currentInput = sc.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();


        while (!currentInput.equals("print")) {
            if (currentInput.equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.poll());
                }

            } else {
                printerQueue.offer(currentInput);
            }


            currentInput = sc.nextLine();

        }
        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }

    }
}

