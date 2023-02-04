import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        Map<String, String> phonebook = new LinkedHashMap<>();

        while (!input.equals("search")) {
            String[] info = input.split("-");
            String name = info[0];
            String number = info[1];
            if (!phonebook.containsKey(name)) {
                phonebook.put(name, number);

            } else {
                phonebook.replace(name, number);
            }

            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }


            input = scanner.nextLine();
        }
        System.out.println();
    }
}
