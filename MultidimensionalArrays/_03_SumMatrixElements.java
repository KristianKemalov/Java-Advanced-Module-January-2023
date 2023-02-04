package MultidimensionalArrays;

import java.util.Scanner;

public class _03_SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] rowsAndCols = sc.nextLine().split(", ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];


        for (int i = 0; i < rows; i++) {
            String[] columnData = sc.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(columnData[j]);
            }
        }

        int sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
