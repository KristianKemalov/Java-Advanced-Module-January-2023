package MultidimensionalArrays;

import java.util.Scanner;

public class _07_DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[n][n];

        fillMatrix(matrix, sc);
        int sumPrimary = getSumOnPrimaryDiagonal(matrix);
        int sumSecondary = getSumOnSecondaryDiagonal(matrix);
        int result = Math.abs(sumPrimary - sumSecondary);
        System.out.println(result);

    }

    private static int getSumOnSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int currentElement = matrix[i][j];
                if (j == matrix.length - i - 1) {
                    sum += currentElement;
                }

            }

        }


        return sum;
    }

    private static int getSumOnPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }


        return sum;

    }

    private static void fillMatrix(int[][] matrix, Scanner sc) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = sc.nextInt();

            }

        }
    }
}
