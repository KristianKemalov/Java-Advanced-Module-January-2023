package MultidimensionalArrays;

import java.util.Scanner;

public class _06_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());


        String[][] matrixA = new String[m][n];
        String[][] matrixB = new String[m][n];


        for (int i = 0; i < m; i++) {
            String[] columnData = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = (columnData[j]);
            }

        }
        for (int i = 0; i < m; i++) {
            String[] columnData = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrixB[i][j] = (columnData[j]);
            }

        }

        String[][] martrixResult = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrixA[i][j].equals(matrixB[i][j])) {
                    martrixResult[i][j] = matrixA[i][j];
                } else {
                    martrixResult[i][j] = "*";
                }


            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(martrixResult[i][j] + " ");

            }
            System.out.println();

        }


    }
}
