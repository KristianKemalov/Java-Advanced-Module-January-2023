package Exam;

import java.util.*;
import java.util.stream.Stream;

public class ApocalypsePreparation {
    static final int PATCH = 30;
    static final int BANDAGE = 40;
    static final int MED_KIT = 100;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        Deque<Integer> textiles = new ArrayDeque<>();
        Deque<Integer> medicaments = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).forEach(textiles::offer);
        Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).forEach(medicaments::push);

        int patchCounter = 0;
        int bandageCounter = 0;
        int medCounter = 0;


        while (!textiles.isEmpty() && !medicaments.isEmpty()) {

            int currentTextile = textiles.poll();
            int currentMedicament = medicaments.pop();
            int possible = currentTextile + currentMedicament;

            switch (possible) {
                case PATCH:
                    patchCounter++;
                    break;
                case BANDAGE:
                    bandageCounter++;
                    break;
                case MED_KIT:
                    medCounter++;
                    break;
                default:
                    if (possible > 100) {
                        medCounter++;
                        int remain = possible - 100;
                        Integer next = medicaments.pop();
                        medicaments.push(next + remain);
                    } else {
                        medicaments.push(currentMedicament + 10);
                    }
            }

        }
        Map<String, Integer> result = new TreeMap<>();
        if (patchCounter > 0) {
            result.put("Patch", patchCounter);
        }
        if (bandageCounter > 0) {
            result.put("Bandage", bandageCounter);
        }
        if (medCounter > 0) {
            result.put("MedKit", medCounter);
        }
        Stream<Map.Entry<String, Integer>> sorted = result.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));


        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else if (medicaments.isEmpty()) {
            System.out.println("Medicaments are empty.");
        }

        sorted.forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

        if (!medicaments.isEmpty()) {
            System.out.printf("Medicaments left: %s%n", String.join(", ", Arrays.asList(medicaments.toString().
                    substring(1, medicaments.toString().length() - 1))));
        }
        if (!textiles.isEmpty()) {
            System.out.printf("Textiles left: %s%n", String.join(", ", Arrays.asList(textiles.toString().
                    substring(1, textiles.toString().length() - 1))));
        }

    }
}
