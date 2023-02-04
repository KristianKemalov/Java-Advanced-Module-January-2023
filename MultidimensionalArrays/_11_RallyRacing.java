package MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11_RallyRacing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String carNumber = sc.nextLine();
        int km = 0;

        String[][] trace = new String[n][n];
        fillMatrix(trace, sc);

        int currentRow = 0;
        int currentCol = 0;

        List<Integer> tunnelsCoordinates = new ArrayList<>();
        findTunnels(trace, tunnelsCoordinates);

        String direction = sc.nextLine();

        while (!direction.equals("End")) {

            switch (direction) {
                case "left":
                    currentCol--;
                    break;
                case "right":
                    currentCol++;
                    break;
                case "up":
                    currentRow--;
                    break;
                case "down":
                    currentRow++;
                    break;
            }
            String movedPlace = trace[currentRow][currentCol];

            if (movedPlace.equals(".")) {
                km += 10;
            } else if (movedPlace.equals("T")) {
                km += 30;
                currentRow = tunnelsCoordinates.get(2);
                currentCol = tunnelsCoordinates.get(3);
                trace[tunnelsCoordinates.get(0)][tunnelsCoordinates.get(1)] = ".";
                trace[tunnelsCoordinates.get(2)][tunnelsCoordinates.get(3)] = ".";


            } else if (movedPlace.equals("F")) {
                km += 10;
                System.out.printf("Racing car %s finished the stage!%n", carNumber);
                break;
            }


            direction = sc.nextLine();
        }
        if (direction.equals("End")) {
            System.out.printf("Racing car %s DNF.%n", carNumber);
        }
        System.out.printf("Distance covered %d km.%n", km);

        trace[currentRow][currentCol] = "C";

        printMatrix(trace);


    }

    private static void printMatrix(String[][] trace) {
        for (int i = 0; i < trace.length; i++) {
            for (int j = 0; j < trace.length; j++) {
                System.out.print(trace[i][j]);

            }
            System.out.println();

        }
    }

    private static void findTunnels(String[][] trace, List<Integer> tunnelsCoordinates) {

        for (int i = 0; i < trace.length; i++) {
            for (int j = 0; j < trace[0].length; j++) {
                String currentElement = trace[i][j];
                if (currentElement.equals("T")) {
                    tunnelsCoordinates.add(i);
                    tunnelsCoordinates.add(j);
                }

            }
        }
    }

    private static void fillMatrix(String[][] trace, Scanner sc) {
        for (int i = 0; i < trace.length; i++) {
            trace[i] = sc.nextLine().split(" ");
        }
    }
}
