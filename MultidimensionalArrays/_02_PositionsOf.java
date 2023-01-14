package MultidimensionalArrays;

import java.util.Scanner;

public class _02_PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] rowsAndCols = sc.nextLine().split(" ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];
        boolean isFound = false;

        for (int i = 0; i < rows; i++) {
            String[] columnData = sc.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {

                matrix[i][j] = Integer.parseInt(columnData[j]);

            }

        }
        int search = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == search) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }

            }

        }
        if (!isFound) {
            System.out.println("not found");
        }

    }
}
