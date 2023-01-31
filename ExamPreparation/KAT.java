package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class KAT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> plates = new ArrayDeque<>();
        Deque<Integer> cars = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt).forEach(plates::offer);
        Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt).forEach(cars::push);

        int carsRegistered = 0;
        int days = 0;
        while (!plates.isEmpty() && !cars.isEmpty()) {

            int currentPlates = plates.peek();
            int currentCars = cars.peek();

            if (currentPlates / 2 < currentCars) {
                carsRegistered += currentPlates / 2;
                plates.poll();
                currentCars = currentCars - currentPlates / 2;
                cars.pop();
                cars.addLast(currentCars);
            } else if (currentPlates / 2 > currentCars) {

                carsRegistered += currentCars;
                cars.pop();
                currentPlates = currentPlates - currentCars * 2;
                plates.poll();
                plates.offer(currentPlates);
            } else {
                cars.pop();
                plates.poll();
                carsRegistered += currentCars;
            }
            days++;

        }
        System.out.printf("%d cars were registered for %d days!%n", carsRegistered, days);
        if (plates.isEmpty() && cars.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        } else if (!plates.isEmpty()) {
            int sum = 0;
            for (int n : plates) {
                sum += n;
            }
            System.out.printf("%d license plates remain!", sum);
        } else if (!cars.isEmpty()) {
            int sum = 0;
            for (int n : cars) {
                sum += n;
            }
            System.out.printf("%d cars remain without license plates!", sum);

        }

    }
}
