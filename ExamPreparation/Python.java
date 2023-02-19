package ExamPreparation;

import java.util.Scanner;

public class Python {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] commands = sc.nextLine().split(", ");
        char[][] matrix = new char[n][];
        int snakeRow = -1;
        int snakeCol = -1;
        int foodCounter = 0;

        for (int i = 0; i < n; i++) {
            matrix[i] = sc.nextLine().replaceAll(" ", "").toCharArray();
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 's') {
                    snakeRow = i;
                    snakeCol = j;
                } else if (matrix[i][j] == 'f') {
                    foodCounter++;
                }

            }
        }
        boolean isKilled = false;
        int length = 1;
        for (String command : commands) {
            switch (command) {
                case "left": snakeCol--;break;
                case "right": snakeCol++;break;
                case "down": snakeRow++;break;
                case "up":snakeRow--;break;
            }
            if (snakeRow < 0) {
                snakeRow = n - 1;
            } else if (snakeRow >= n) {
                snakeRow = 0;
            } else if (snakeCol < 0) {
                snakeCol = n - 1;
            } else if (snakeCol >= n) {
                snakeCol = 0;
            }

            if (matrix[snakeRow][snakeCol] == 'e') {
                isKilled = true;
                break;
            } else if (matrix[snakeRow][snakeCol] == 'f') {
                length++;
                foodCounter--;
            }
            if (foodCounter==0){
                break;
            }
        }
        if (isKilled) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (foodCounter == 0) {
            System.out.printf("You win! Final python length is %d%n", length);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", foodCounter);
        }


    }
}
