import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, LinkedHashMap<String, ArrayList<String>>> info = new LinkedHashMap<>();


        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String continent = input[0];
            String country = input[1];
            String city = input[2];


            if (info.containsKey(continent)) {
                if (info.get(continent).containsKey(country)) {
                    info.get(continent).get(country).add(city);


                } else {
                    info.get(continent).put(country, new ArrayList<>());
                    info.get(continent).get(country).add(city);

                }
            } else {
                info.put(continent, new LinkedHashMap<>());
                info.get(continent).put(country, new ArrayList<>());
                info.get(continent).get(country).add(city);


            }
        }

        for (String continent : info.keySet()) {
            System.out.println(continent + ":");
            for (Map.Entry<String, ArrayList<String>> entry : info.get(continent).entrySet()) {
                System.out.print(entry.getKey() + " -> ");
                int counter = entry.getValue().size();
                for (int i = 0; i < entry.getValue().size(); i++) {
                    if (counter == 1) {
                        System.out.print(entry.getValue().get(i));
                    } else {
                        System.out.print(entry.getValue().get(i) + ", ");

                    }
                    counter--;

                }
                System.out.println();
            }


        }

    }
}
