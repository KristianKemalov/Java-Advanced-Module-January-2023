package SetsAndMaps;

import java.util.*;

public class _12_UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        TreeMap<String, LinkedHashMap<String, Integer>> info = new TreeMap<>();

        while (!input.equals("end")) {

            String ip = input.split("\\s+")[0].split("=")[1];
            String username = input.split("\\s+")[2].split("=")[1];


            if (!info.containsKey(username)) {
                info.put(username, new LinkedHashMap<>());
            }
            Map<String, Integer> currentIPs = info.get(username);
            if (!currentIPs.containsKey(ip)) {
                currentIPs.put(ip, 1);
            } else {
                currentIPs.put(ip, currentIPs.get(ip) + 1);
            }
            input = sc.nextLine();
        }

        for (String user : info.keySet()) {
            System.out.println(user + ":");
            Map<String, Integer> currentIPs = info.get(user);
            int countIPs = currentIPs.size();


            for (String ip : currentIPs.keySet()) {
                if (countIPs == 1) {


                    System.out.println(ip + " => " + currentIPs.get(ip) + ".");
                } else {
                    System.out.print(ip + " => " + currentIPs.get(ip) + ", ");

                }
                countIPs--;
            }

        }

    }
}
