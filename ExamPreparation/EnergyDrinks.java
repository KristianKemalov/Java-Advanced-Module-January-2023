package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class EnergyDrinks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        ArrayDeque<Integer> milligrams = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinks = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(milligrams::push);
        Arrays.stream(sc.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).forEach(energyDrinks::offer);

        int totalCaffeine = 0;

        while (!milligrams.isEmpty() && !energyDrinks.isEmpty()) {


            if (milligrams.getFirst() * energyDrinks.getFirst() <= 300 - totalCaffeine) {

                totalCaffeine += milligrams.getFirst() * energyDrinks.getFirst();
                milligrams.removeFirst();
                energyDrinks.removeFirst();
            } else {
                if (totalCaffeine >= 30) {
                    totalCaffeine -= 30;
                }
                milligrams.removeFirst();
                int energyToRemove = energyDrinks.getFirst();
                energyDrinks.removeFirst();
                energyDrinks.offerLast(energyToRemove);


            }

        }
        if (!energyDrinks.isEmpty()) {
            System.out.printf("Drinks left: %s%n", String.join(", ", Arrays.asList(energyDrinks.toString().
                    substring(1, energyDrinks.toString().length() - 1))));
        } else {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        }
        System.out.printf("Stamat is going to sleep with %s mg caffeine.", totalCaffeine);

    }
}
