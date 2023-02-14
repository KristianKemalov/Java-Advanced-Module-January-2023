package ExamPreparation;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int size=Integer.parseInt(sc.nextLine());
        char[][] matrix=new char[size][size];

        fillMatrix(matrix,sc);
        int startRow=-1;
        int startCol=-1;
        boolean isWithinLimits=true;
        int gold=0;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j]=='A'){
                    startRow=i;
                    startCol=j;
                }
            }
        }
        while (gold<65 && isWithinLimits){
            String command = sc.nextLine();

            matrix[startRow][startCol]='-';

            switch (command){
                case "up":startRow--;break;
                case "down":startRow++;break;
                case "left":startCol--;break;
                case "right":startCol++;break;
            }

            if (startRow<0||startRow>=size||startCol<0||startCol>=size){
                isWithinLimits=false;
                continue;
            }
            if (matrix[startRow][startCol]=='M'){
                matrix[startRow][startCol]='-';

                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        if (matrix[i][j]=='M'){
                            startRow=i;
                            startCol=j;
                            matrix[startRow][startCol]='-';
                        }
                    }
                }
            }else if (matrix[startRow][startCol]=='-'){
                matrix[startRow][startCol]='-';

            }else {
                int currentGold=Character.getNumericValue(matrix[startRow][startCol]);
                gold+=currentGold;
            }

            matrix[startRow][startCol]='A';
        }

        if (gold<65){
            System.out.println("I do not need more swords!");
        }else {
            System.out.println("Very nice swords, I will come back for more!");
        }
        System.out.printf("The king paid %d gold coins.%n",gold);
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j <matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix,Scanner sc) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i]=sc.nextLine().toCharArray();
        }

    }
}
