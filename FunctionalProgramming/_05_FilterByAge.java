package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _05_FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = Integer.parseInt(sc.nextLine());

        LinkedHashMap<String, Integer> data = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] currentLine = sc.nextLine().split(", ");
            String name = currentLine[0];
            int age = Integer.parseInt(currentLine[1]);

            data.put(name, age);
        }

        String condition = sc.nextLine();
        int ageLimit = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();

        Predicate<Integer> filter = getPredicate(condition, ageLimit);
        Consumer<Map.Entry<String, Integer>> print = getPrintConsumer(format);


        data
                .entrySet().stream()
                .filter(entry -> filter.test(entry.getValue()))
                .forEach(entry -> print.accept(entry));



    }

    private static Consumer<Map.Entry<String,Integer>> getPrintConsumer(String format) {
        if (format.equals("name")){
            return e-> System.out.println(e.getKey());
        }else if (format.equals("age")){
            return e-> System.out.println(e.getValue());
        }else if (format.equals("name age")){
            return e-> System.out.printf("%s - %d%n",e.getKey(),e.getValue());
        }
        throw new RuntimeException("Bad format!");

    }

    private static Predicate<Integer> getPredicate(String condition, int ageLimit) {
        if (condition.equals("older")){
            return x->x>=ageLimit;
        }else if (condition.equals("younger")){
            return x->x<=ageLimit;
        }
        throw new RuntimeException("Bad condition!");
    }
}
