import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _07_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, LinkedHashMap<String, Double>> info = new TreeMap<>();


        while (!input.equals("Revision")) {
            String[] parts = input.split(", ");

            String shop = parts[0];
            String product = parts[1];
            double price = Double.parseDouble(parts[2]);

            if (info.containsKey(shop)) {
                info.get(shop).put(product, price);


            } else {
                info.put(shop, new LinkedHashMap<>());
                info.get(shop).put(product, price);
            }

            input = scanner.nextLine();

        }

        for (String shop : info.keySet()) {
            System.out.println(shop + "->");
            for (String product : info.get(shop).keySet()) {
                System.out.print("Product: " + product + ", ");
                System.out.printf(("Price: %.1f"), info.get(shop).get(product));
                System.out.println();

            }
        }

    }
}