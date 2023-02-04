import java.util.ArrayDeque;
import java.util.Scanner;

public class _15_BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> backStack = new ArrayDeque<>();
        ArrayDeque<String> forwardQueue = new ArrayDeque<>();
        String lastVisited="";

        while (!input.equals("Home")) {

            if (input.equals("forward") && forwardQueue.isEmpty()) {
                System.out.println("no next URLs");
            } else if (input.equals("forward")) {
                backStack.push(forwardQueue.peek());
                System.out.println(forwardQueue.poll());
                forwardQueue.clear();


            } else if (input.equals("back")) {
                if (backStack.isEmpty()) {
                    System.out.println("no previous URLs");
                } else {

                    backStack.pop();
                    if (backStack.isEmpty()) {
                        System.out.println("no previous URLs");
                    } else {
                        System.out.println(backStack.peek());
                    }

                }

            } else {

                forwardQueue.addFirst(input);
                System.out.println(input);
                backStack.push(input);
                 lastVisited=input;

            }


            input = scanner.nextLine();

        }
    }
}
