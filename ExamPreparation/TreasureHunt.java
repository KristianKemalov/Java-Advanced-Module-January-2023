package ExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);


        char[][] matrix = new char[n][m];
        fillMatrix(matrix, sc);
        int currentRow = -1;
        int currentCol = -1;
        List<String> path = new ArrayList<>();

        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]=='Y') {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }

        String command = sc.nextLine();

        while (!command.equals("Finish")) {


            if (command.equals("up")) {
                if (currentRow - 1 >= 0 && matrix[currentRow - 1][currentCol]!='T') {
                    currentRow--;
                    path.add(command);
                }


            } else if (command.equals("down")) {

                if (currentRow + 1 < n && matrix[currentRow + 1][currentCol]!='T') {
                    currentRow++;
                    path.add(command);
                }

            } else if (command.equals("right")) {
                if (currentCol + 1 < m && matrix[currentRow][currentCol + 1]!='T') {
                    currentCol++;
                    path.add(command);
                }


            } else if (command.equals("left")) {

                if (currentCol - 1 >= 0 && matrix[currentRow][currentCol - 1]!='T') {
                    currentCol--;
                    path.add(command);
                }

            }
            command = sc.nextLine();

        }
        if (matrix[currentRow][currentCol]=='X') {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s", String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }

    }

    private static void fillMatrix(char[][] matrix, Scanner sc) {
        for (int row = 0; row < matrix.length; row++) {


            matrix[row] = sc.nextLine().replace(" ","").toCharArray();
        }
    }
}