package SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _11_FixEmails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String name = sc.nextLine();
        Map<String, String> info = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = sc.nextLine();
            if (!email.endsWith("com") && !email.endsWith("us") && !email.endsWith("uk")) {
                info.put(name, email);
            }
            name = sc.nextLine();
        }
        info.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

    }
}
