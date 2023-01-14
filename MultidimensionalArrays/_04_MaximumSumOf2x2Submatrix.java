package MultidimensionalArrays;

import java.util.Scanner;

public class _04_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] rowsAndColumns = sc.nextLine().split(", ");
        int rows = Integer.parseInt(rowsAndColumns[0]);
        int cols = Integer.parseInt(rowsAndColumns[1]);

        int[][] matrix = new int[rows][cols];


        for (int i = 0; i < rows; i++) {
            String[] columnData = sc.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(columnData[j]);

            }
        }
        int maxSum = 0;
        int maxSumTopLeftRow = -1;
        int maxSumTopLeftCol = -1;

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxSumTopLeftRow = i;
                    maxSumTopLeftCol = j;

                }
            }

        }
        System.out.println(matrix[maxSumTopLeftRow][maxSumTopLeftCol] + " " + matrix[maxSumTopLeftRow][maxSumTopLeftCol + 1]);
        System.out.println(matrix[maxSumTopLeftRow + 1][maxSumTopLeftCol] + " " + matrix[maxSumTopLeftRow + 1][maxSumTopLeftCol + 1]);
        System.out.println(maxSum);

    }
}
