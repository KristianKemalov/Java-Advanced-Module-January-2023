package ExamPreparation;

import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] effectsInfo = sc.nextLine().split(", ");
        Deque<Integer> bombEffects = new ArrayDeque<>();
        for (String effect : effectsInfo) {
            bombEffects.offer(Integer.parseInt(effect));
        }

        String[] casingInfo = sc.nextLine().split(", ");
        Deque<Integer> bombCasing = new ArrayDeque<>();
        for (String casing : casingInfo) {
            bombCasing.push(Integer.parseInt(casing));
        }

        int datura=0;
        int cherry=0;
        int smokeDecoy=0;
boolean isReady=false;
        while (!bombEffects.isEmpty()&& !bombCasing.isEmpty()&& !isReady) {
            int effect=bombEffects.poll();
            int casing=bombCasing.pop();
            int possibleBomb = effect+casing;

            switch (possibleBomb){
                case 40:datura++; break;
                case 60:cherry++;break;
                case 120:smokeDecoy++;break;
                default:bombCasing.push(casing-5);bombEffects.offerFirst(effect);
            }

            if (datura>=3&&cherry>=3&&smokeDecoy>=3){
                isReady=true;
            }
        }

        if (isReady){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffects.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: ");

            System.out.println(bombEffects.toString().replaceAll("[\\[\\]]", ""));
        }

        if (bombCasing.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.print("Bomb Casings: ");
            System.out.println(bombCasing.toString().replaceAll("[\\[\\]]", ""));
        }


        TreeMap<String,Integer> result=new TreeMap<>();
        result.put("Cherry Bombs",cherry);
        result.put("Datura Bombs",datura);
        result.put("Smoke Decoy Bombs",smokeDecoy);

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

    }
}
