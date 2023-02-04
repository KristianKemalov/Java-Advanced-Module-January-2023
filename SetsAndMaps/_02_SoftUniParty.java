import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> vip = new TreeSet<>();


        while (!input.equals("PARTY")) {
            vip.add(input);


            input = scanner.nextLine();
        }
        input = scanner.nextLine();


        while (!input.equals("END")) {

            vip.remove(input);
            input = scanner.nextLine();


        }

        System.out.println(vip.size());
        for (String guests : vip) {
            System.out.println(guests);

        }
    }
}
