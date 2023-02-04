package MultidimensionalArrays;

import java.util.Scanner;

public class _08_MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] dimensions = sc.nextLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);


        String[][] matrix = new String[n][m];
        fillMatrix(matrix, sc);

        String command = sc.nextLine();
        while (!command.equals("END")) {

            if (validateInput(command, n, m)) {
                String[] parts = command.split(" ");
                int row1 = Integer.parseInt(parts[1]);
                int col1 = Integer.parseInt(parts[2]);
                int row2 = Integer.parseInt(parts[3]);
                int col2 = Integer.parseInt(parts[4]);

                String firstElement = matrix[row1][col1];
                String secondElement = matrix[row2][col2];

                matrix[row1][col1] = secondElement;
                matrix[row2][col2] = firstElement;


                printMatrix(matrix);


            } else {
                System.out.println("Invalid input!");
            }
            command = sc.nextLine();
        }
    }

    private static boolean validateInput(String command, int rows, int cols) {
        String[] parts = command.split(" ");
        if (parts.length != 5) {
            return false;
        }
        if (!parts[0].equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(parts[1]);
        int col1 = Integer.parseInt(parts[2]);
        int row2 = Integer.parseInt(parts[3]);
        int col2 = Integer.parseInt(parts[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col2 < 0 || col2 >= cols || col1 < 0 || col1 >= cols) {
            return false;
        }
        return true;

    }

    private static void fillMatrix(String[][] matrix, Scanner sc) {

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = sc.nextLine().split("\\s+");
        }
    }


    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }

    }
}
