package Classes._01_Car;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            String[] carParts = sc.nextLine().split(" ");
            Car car = new Car();
            car.setBrand(carParts[0]);
            car.setModel(carParts[1]);
            car.setHorsePower(Integer.parseInt(carParts[2]));
            System.out.println(car.carInfo());

        }

    }
}
