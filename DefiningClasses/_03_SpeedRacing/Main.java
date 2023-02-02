package Classes._03_SpeedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int countCars = Integer.parseInt(sc.nextLine());
        Map<String,Car> cars=new LinkedHashMap<>();

        for (int i = 0; i < countCars; i++) {
            String[] data = sc.nextLine().split(" ");
            String model = data[0];
            double fuelAmount = Double.parseDouble(data[1]);
            double priceFuelPerKm = Double.parseDouble(data[2]);

            Car car = new Car(model, fuelAmount, priceFuelPerKm);
            cars.put(model,car);


        }
        String command = sc.nextLine();

        while (!command.equals("End")) {
            String carModelToDrive = command.split(" ")[1];
            int kmToDrive = Integer.parseInt(command.split(" ")[2]);

            Car carToDrive=cars.get(carModelToDrive);

            if (!carToDrive.drive(kmToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }



            command = sc.nextLine();
        }
        for (Car car:cars.values()){
            System.out.println(car.toString());
        }


    }
}
