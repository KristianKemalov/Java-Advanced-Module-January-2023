package MultidimensionalArrays;

import java.util.Scanner;

public class _13_StickyFingers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        String[] commands = sc.nextLine().split(",");
        String[][] matrix = new String[n][n];

        fillMatrix(matrix, sc);
        int currentRow = -1;
        int currentCol = -1;
        int pocket = 0;
        boolean isCaught = false;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j].equals("D")) {
                    currentRow = i;
                    currentCol = j;
                }
            }
        }
        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            switch (currentCommand) {
                case "left":
                    if (currentCol - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[currentRow][currentCol] = "+";
                        currentCol--;
                    }
                    break;
                case "right":
                    if (currentCol + 1 >= n) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[currentRow][currentCol] = "+";
                        currentCol++;
                    }
                    break;
                case "up":
                    if (currentRow - 1 < 0) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[currentRow][currentCol] = "+";
                        currentRow--;
                    }
                    break;
                case "down":
                    if (currentRow + 1 >= n) {
                        System.out.println("You cannot leave the town, there is police outside!");
                    } else {
                        matrix[currentRow][currentCol] = "+";
                        currentRow++;
                    }

                    break;
            }
            if (matrix[currentRow][currentCol].equals("$")) {
                matrix[currentRow][currentCol] = "+";
                System.out.printf("You successfully stole %d$.%n", currentRow * currentCol);
                pocket += currentCol * currentRow;
            }
            if (matrix[currentRow][currentCol].equals("P")) {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", pocket);
                matrix[currentRow][currentCol] = "#";
                isCaught = true;
                break;
            }

        }
        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", pocket);
            matrix[currentRow][currentCol] = "D";
        }
        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(String.join(" ", matrix[i]));
        }

    }

    private static void fillMatrix(String[][] matrix, Scanner sc) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = sc.nextLine().split(" ");

        }
    }
}
