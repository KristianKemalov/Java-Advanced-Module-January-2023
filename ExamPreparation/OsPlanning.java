package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OsPlanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        Arrays.stream(sc.nextLine().split(", ")).map(Integer::parseInt).forEach(tasks::push);
        Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).forEach(threads::offer);
        int n = Integer.parseInt(sc.nextLine());

        boolean isKilled = false;
        int threadKiller = -1;

        while (!isKilled && !threads.isEmpty() && !tasks.isEmpty()) {
            int currentTask = tasks.pop();
            int currentThread = threads.poll();

            if (currentTask == n) {
                isKilled = true;
                threadKiller = currentThread;
                threads.offerFirst(threadKiller);
                continue;
            }
            if (currentThread < currentTask) {
                tasks.push(currentTask);
            }

        }
        System.out.printf("Thread with value %d killed task %d%n", threadKiller, n);

        int counter = 0;
        for (Integer m : threads) {

            if (counter != threads.size()) {
                System.out.print(m + " ");
            } else {
                System.out.print(m);
            }
            counter++;
        }


    }
}
