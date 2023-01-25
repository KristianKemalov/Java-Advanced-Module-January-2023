package MultidimensionalArrays;

import java.util.Scanner;

public class _12_NavyBattle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[][] matrix = new String[n][n];
        fillMatrix(matrix, sc);

        int submarineRow = -1;
        int submarineCol = -1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("S")) {
                    submarineRow = i;
                    submarineCol = j;
                }
            }

        }
        String command = sc.nextLine();
        int mineCounter = 0;
        int cruiserCounter = 0;

        while (mineCounter < 3 && cruiserCounter < 3) {
            matrix[submarineRow][submarineCol] = "-";
            if (command.equals("down")) {
                submarineRow++;

            } else if (command.equals("up")) {
                submarineRow--;

            } else if (command.equals("right")) {
                submarineCol++;

            } else if (command.equals("left")) {
                submarineCol--;

            }
            if (matrix[submarineRow][submarineCol].equals("-")) {
                command = sc.nextLine();
                continue;
            } else if (matrix[submarineRow][submarineCol].equals("*")) {
                mineCounter++;
                if (mineCounter < 3) {
                    matrix[submarineRow][submarineCol] = "-";
                } else {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%s, %s]!%n", submarineRow, submarineCol);

                    break;

                }


            } else if (matrix[submarineRow][submarineCol].equals("C")) {
                cruiserCounter++;
                matrix[submarineRow][submarineCol] = "-";

                if (cruiserCounter == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }

            }
            command = sc.nextLine();
        }
        matrix[submarineRow][submarineCol] = "S";

        printMatrix(matrix);

    }


    private static void fillMatrix(String[][] matrix, Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {

            matrix[row] = sc.nextLine().split("");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println(); //свали курсора на следващия ред
        }
    }
}
