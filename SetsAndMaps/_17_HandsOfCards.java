import javax.xml.namespace.QName;
import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();

        Map<String, List<String>> data = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] parts = input.split(": ");
            String name = parts[0];
            List<String> cards = Arrays.stream(parts[1].split(", ")).collect(Collectors.toList());


            if (!data.containsKey(name)) {
                data.put(name, new ArrayList<>());
                for (int i = 0; i < cards.size(); i++) {
                    if (i == 0) {
                        data.get(name).add(cards.get(i));
                    } else if (data.get(name).contains(cards.get(i))) {
                        break;
                    } else {
                        data.get(name).add(cards.get(i));

                    }

                }

            } else {
                for (int i = 0; i < cards.size(); i++) {

                    if (!data.get(name).contains(cards.get(i))) {
                        data.get(name).add(cards.get(i));
                    }
                }

            }
            input = scanner.nextLine();
        }


        for (Map.Entry<String, List<String>> entry : data.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            int sum = 0;

            for (int i = 0; i < entry.getValue().size(); i++) {

                String[] info = (entry.getValue().get(i).split("[A-Z]"));
                int powerN = 0;
                if (info.length == 0) {
                    String info2 = (entry.getValue().get(i));
                    if (info2.startsWith("J")) {
                        powerN = 11;
                    } else if (info2.startsWith("Q")) {
                        powerN = 12;
                    } else if (info2.startsWith("K")) {
                        powerN = 13;
                    } else if (info2.startsWith("A")) {
                        powerN = 14;
                    }
                    if (info2.endsWith("D")) {
                        sum += powerN * 2;
                    } else if (info2.endsWith("C")) {
                        sum += powerN;
                    } else if (info2.endsWith("S")) {
                        sum += powerN * 4;
                    } else if (info2.endsWith("H")) {
                        sum += powerN * 3;
                    }
                } else {

                    if (info[0].equals("J")) {
                        powerN = 11;
                    } else if (info[0].equals("Q")) {
                        powerN = 12;
                    } else if (info[0].equals("K")) {
                        powerN = 13;
                    } else if (info[0].equals("A")) {
                        powerN = 14;
                    } else {
                        powerN = Integer.parseInt(info[0]);
                    }
                    String type = (entry.getValue().get(i).split("[0-9]+")[1]);

                    if (type.equals("D")) {
                        sum = sum + powerN * 2;
                    } else if (type.equals("C")) {
                        sum = sum + powerN;
                    } else if (type.equals("S")) {
                        sum = sum + powerN * 4;
                    } else if (type.equals("H")) {
                        sum = sum + powerN * 3;
                    }

                }
            }
            System.out.println(sum);

        }

    }
}
