package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;

public class Meeting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] malesInfo = sc.nextLine().split(" ");
        Deque<Integer> males = new ArrayDeque<>();
        for (String male : malesInfo) {
            int maleToAdd = Integer.parseInt(male);
            if (maleToAdd > 0) {
                males.push(maleToAdd);
            }
        }

        String[] femalesInfo = sc.nextLine().split(" ");
        Deque<Integer> females = new ArrayDeque<>();
        for (String female : femalesInfo) {
            int femaleToAdd = Integer.parseInt(female);
            if (femaleToAdd > 0) {
                females.offer(femaleToAdd);
            }
        }

        int matchCounter = 0;

        while (!males.isEmpty() && !females.isEmpty()) {
            int malePower = males.peek();
            int femalePower = females.peek();

            if (malePower%25==0){
                males.pop();
            }else if (femalePower%25==0){
                females.poll();
            }

            if (malePower != femalePower) {
                males.pop();
                males.push(malePower - 2);
                females.poll();
            }else {
                males.pop();
                females.poll();
                matchCounter++;
            }

        }

        System.out.println();
    }

}
