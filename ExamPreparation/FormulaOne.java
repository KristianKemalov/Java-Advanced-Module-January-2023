import java.util.Scanner;

public class FormulaOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size=Integer.parseInt(sc.nextLine());
        int amountCommands=Integer.parseInt(sc.nextLine());
        char[][] matrix=new char[size][size];
        int startRow=-1;
        int startCol=-1;
        boolean isFinished=false;
        int commandCounter=0;


        for (int i = 0; i < size; i++) {
            matrix[i]=sc.nextLine().toCharArray();
            for (int j = 0; j < size; j++) {
                if (matrix[i][j]=='P'){
                    startRow=i;
                    startCol=j;
                }
            }
        }
        while (!isFinished &&commandCounter<amountCommands){
            String command = sc.nextLine();

            matrix[startRow][startCol]='.';

            switch (command){
                case "up":startRow--;break;
                case "down":startRow++;break;
                case "left":startCol--;break;
                case "right":startCol++;break;
            }


            if (startRow<0){
                startRow=size-1;
            }else if (startRow>=size){
                startRow=0;
            }else if (startCol<0){
                startCol=size-1;
            }else if (startCol>=size){
                startCol=0;
            }

            if (matrix[startRow][startCol]=='B'){
                switch (command){
                    case "up":startRow--;break;
                    case "down":startRow++;break;
                    case "left":startCol--;break;
                    case "right":startCol++;break;

                }
                if (startRow<0){
                    startRow=size-1;
                }else if (startRow>=size){
                    startRow=0;
                }else if (startCol<0){
                    startCol=size-1;
                }else if (startCol>=size){
                    startCol=0;
                }


            }else if (matrix[startRow][startCol]=='T'){
                switch (command){
                    case "up":startRow++;break;
                    case "down":startRow--;break;
                    case "left":startCol++;break;
                    case "right":startCol--;break;
                }
            }else if (matrix[startRow][startCol]=='F'){
                isFinished=true;
                continue;
            }
            matrix[startRow][startCol]='P';
            commandCounter++;
        }

        if (isFinished){
            matrix[startRow][startCol]='P';
            System.out.println("Well done, the player won first place!");
        }else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();

        }
    }
}
