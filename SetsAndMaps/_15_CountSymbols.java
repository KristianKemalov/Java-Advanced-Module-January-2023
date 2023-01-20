import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> data = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!data.containsKey(currentChar)) {
                data.put(currentChar, 1);
            } else {
                data.put(currentChar, data.get(currentChar) + 1);
            }

        }

        for (Map.Entry<Character, Integer> entry : data.entrySet()) {

            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }


    }
}
