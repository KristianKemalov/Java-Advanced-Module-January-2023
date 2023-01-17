package MultidimensionalArrays;

import java.util.Scanner;

public class _10_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int[][] matrix = new int[n][m];
        int[][] maxMatrix = new int[3][3];
        fillMatrix(matrix, scanner);
        findMaxSum(matrix, maxMatrix);


    }

    private static void findMaxSum(int[][] matrix, int[][] maxMatrix) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                currentSum = 0;
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        currentSum += matrix[k][l];

                    }

                }
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startRow = i;
                    startCol = j;

                }

            }


        }
        System.out.println("Sum = " + maxSum);
        for (int i = startRow; i <= startRow + 2; i++) {
            for (int j = startCol; j <= startCol + 2; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }

    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int i = 0; i < matrix.length; i++) {
            String[] columnData = scanner.nextLine().split(" ");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Integer.parseInt(columnData[j]);

            }
        }
    }
}
