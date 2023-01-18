package SetsAndMaps;

import java.util.*;

public class _03_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        String[] inputOne = sc.nextLine().split(" ");

        for (int i = 0; i < inputOne.length; i++) {
            int currentNum = Integer.parseInt(inputOne[i]);
            firstPlayer.add(currentNum);
        }
        String[] inputTwo = sc.nextLine().split(" ");

        for (int i = 0; i < inputTwo.length; i++) {
            int currentNum = Integer.parseInt(inputTwo[i]);
            secondPlayer.add(currentNum);
        }


        int step = 1;
        while (!firstPlayer.isEmpty() && !secondPlayer.isEmpty()) {
            if (step >= 50) {
                break;
            }
            Integer fighterOne = firstPlayer.iterator().next();
            Integer fighterTwo = secondPlayer.iterator().next();

            firstPlayer.remove(fighterOne);
            secondPlayer.remove(fighterTwo);

            if (fighterOne > fighterTwo) {
                firstPlayer.add(fighterOne);
                firstPlayer.add(fighterTwo);

            } else if (fighterTwo > fighterOne) {

                secondPlayer.add(fighterOne);
                secondPlayer.add(fighterTwo);
            }


            step++;

        }


        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
