package Exam;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dimensions = sc.nextLine().split(" ");
        int N=Integer.parseInt(dimensions[0]);
        int M=Integer.parseInt(dimensions[1]);

        char[][] matrix=new char[N][M];
        int startCol=0;
        int startRow=0;
        int touchedOpponents=0;
        int movesMade=0;

        for (int i = 0; i < N; i++) {
            matrix[i]=sc.nextLine().replaceAll(" ","").toCharArray();
            for (int j = 0; j < M; j++) {
                if (matrix[i][j]=='B'){
                    startRow=i;
                    startCol=j;
                }
            }
        }
        String command = sc.nextLine();

        while (!command.equals("Finish")&&touchedOpponents<3){

            switch (command) {
                case "left": startCol--;break;
                case "right": startCol++;break;
                case "down": startRow++;break;
                case "up":startRow--;break;
            }
            if (startCol<0||startCol>=M||startRow<0||startRow>=N){
                switch (command) {
                    case "left": startCol++;break;
                    case "right": startCol--;break;
                    case "down": startRow--;break;
                    case "up":startRow++;break;
                }
                command=sc.nextLine();

                continue;
            }
            if (matrix[startRow][startCol]=='O'){
                switch (command) {
                    case "left": startCol++;break;
                    case "right": startCol--;break;
                    case "down": startRow--;break;
                    case "up":startRow++;break;
                }
                command=sc.nextLine();

                continue;
            }else if (matrix[startRow][startCol]=='P'){
                matrix[startRow][startCol]='-';
                movesMade++;
                touchedOpponents++;
            }else {
                movesMade++;
            }

            command=sc.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d",touchedOpponents,movesMade);
    }
}
