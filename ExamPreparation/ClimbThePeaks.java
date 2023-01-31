package ExamPreparation;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> food = new ArrayDeque<>();
        Deque<Integer> stamina = new ArrayDeque<>();

        ArrayDeque<String> peaks = new ArrayDeque<>(Arrays.asList("Vihren", "Kutelo", "Banski Suhodol", "Polezhan", "Kamenitza"));
        Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt).forEach(food::push);
        Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt).forEach(stamina::offer);


        Map<String, Integer> peaksAndLevel = new LinkedHashMap<>();
        peaksAndLevel.put("Vihren", 80);
        peaksAndLevel.put("Kutelo", 90);
        peaksAndLevel.put("Banski Suhodol", 100);
        peaksAndLevel.put("Polezhan", 60);
        peaksAndLevel.put("Kamenitza", 70);

        Set<String> successPeaks = new LinkedHashSet<>();


        while (!food.isEmpty() && !stamina.isEmpty() && !peaks.isEmpty()) {

            String currentPeak = peaks.getFirst();

            if (food.peek() + stamina.peek() >= peaksAndLevel.get(currentPeak)) {
                successPeaks.add(currentPeak);
                peaksAndLevel.remove(currentPeak);
                food.poll();
                stamina.poll();
                peaks.remove(currentPeak);
            } else {
                food.poll();
                stamina.poll();

            }
        }

        if (peaksAndLevel.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }

        if (!successPeaks.isEmpty()) {
            System.out.println("Conquered peaks:");
            successPeaks.forEach(e -> System.out.println(e));
        }


    }

}

