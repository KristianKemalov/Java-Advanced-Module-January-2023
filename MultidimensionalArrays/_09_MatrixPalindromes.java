package MultidimensionalArrays;

import java.util.Scanner;

public class _09_MatrixPalindromes {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        String[][] matrix = new String[r][c];

        String[] alphabet = "a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z".split(", ");

        generateMatrix(matrix, alphabet);

        printMatrix(matrix);

    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }

    private static void generateMatrix(String[][] matrix, String[] alphabet) {
        StringBuilder currentText = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                currentText.append(alphabet[i]);
                currentText.append(alphabet[j + i]);
                currentText.append(alphabet[i]);
                matrix[i][j] = currentText.toString();
                currentText.delete(0, currentText.length());

            }

        }
    }
}
