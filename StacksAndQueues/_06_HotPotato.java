package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class _06_HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String input = sc.nextLine();
        String[] names = input.split(" ");
        int steps = Integer.parseInt(sc.nextLine());

        ArrayDeque<String> kids = new ArrayDeque<>();

        Collections.addAll(kids, names);


        while (kids.size() > 1) {
            for (int i = 1; i < steps; i++) {
                String kid = kids.poll();
                kids.offer(kid);


            }
            String removedChild = kids.poll();
            System.out.println("Removed " + removedChild);
        }
        System.out.println("Last is "+ kids.poll());
    }
}
