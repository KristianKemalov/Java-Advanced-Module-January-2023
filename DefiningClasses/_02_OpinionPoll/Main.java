package Classes._02_OpinionPoll;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Map<String, Integer> data = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            Person person = new Person(parts[0], Integer.parseInt(parts[1]));
            if (person.getAge() > 30) {
                data.put(person.getName(), person.getAge());
            }

        }
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }


    }
}
