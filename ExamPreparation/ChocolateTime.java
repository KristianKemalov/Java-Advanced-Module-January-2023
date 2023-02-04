package ExamPreparation;

import java.util.*;

public class ChocolateTime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] milk = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();
        double[] cacao = Arrays.stream(sc.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<String, Integer> chocolates = new TreeMap<>();
        chocolates.put("Milk Chocolate", 0);
        chocolates.put("Dark Chocolate", 0);
        chocolates.put("Baking Chocolate", 0);

        Deque<Double> milkQueue = new ArrayDeque<>();
        for (double v : milk) {
            milkQueue.offer(v);
        }
        Deque<Double> cacaoStack = new ArrayDeque<>();
        for (double v : cacao) {
            cacaoStack.push(v);
        }


        while (!cacaoStack.isEmpty() && !milkQueue.isEmpty()) {

            double currentMilk = milkQueue.peek();
            double currentCacao = cacaoStack.peek();
            double percentage = currentCacao / (currentMilk + currentCacao);

            if (percentage == 1) {
                chocolates.put("Baking Chocolate", chocolates.get("Baking Chocolate") + 1);
                cacaoStack.pop();
                milkQueue.poll();
            } else if (percentage == 0.5) {
                chocolates.put("Dark Chocolate", chocolates.get("Dark Chocolate") + 1);
                cacaoStack.pop();
                milkQueue.poll();
            } else if (percentage == 0.3) {
                chocolates.put("Milk Chocolate", chocolates.get("Milk Chocolate") + 1);
                cacaoStack.pop();
                milkQueue.poll();
            } else {
                cacaoStack.poll();
                double newMilk = currentMilk + 10;
                milkQueue.poll();
                milkQueue.offerLast(newMilk);
            }


        }
        boolean isValid = true;
        for (Map.Entry<String, Integer> entry : chocolates.entrySet()) {

            if (entry.getValue() == 0) {
                isValid = false;
                break;

            }
            isValid = true;
        }

        if (isValid) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }
        for (Map.Entry<String, Integer> entry : chocolates.entrySet()) {
            if (entry.getValue() != 0) {
                System.out.printf("# %s --> %d", entry.getKey(), entry.getValue());
                System.out.println();
            }
        }


    }
}
