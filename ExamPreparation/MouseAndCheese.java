import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[n][];

        for (int i = 0; i < n; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }
        int startRow = 0;
        int startCol = 0;
        int eatenCheese = 0;
        int bonusRow = -1;
        int bonusCol = -1;
        boolean isWithinLimits=true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 'M') {
                    startRow = i;
                    startCol = j;
                }else if (matrix[i][j]=='B'){
                    bonusRow=i;
                    bonusCol=j;
                }
            }
        }


        String command = sc.nextLine();
        while (isWithinLimits&& !command.equals("end")){
            matrix[startRow][startCol]='-';

            switch (command){
                case "up":startRow--;break;
                case "down":startRow++;break;
                case "left":startCol--;break;
                case "right":startCol++;break;
            }
            if (startCol<0||startCol>=n||startRow<0||startRow>=n){
                isWithinLimits=false;
                continue;
            }
            if (matrix[startRow][startCol]=='c'){
                eatenCheese++;
            }else if (startCol==bonusCol&&startRow==bonusRow){
                matrix[bonusRow][bonusCol]='-';
                startCol--;
            }

            matrix[startRow][startCol]='M';
            command=sc.nextLine();
        }

        if (!isWithinLimits){
            System.out.println("Where is the mouse?");
        }
        if (eatenCheese<5){
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n",5-eatenCheese);
        }else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n",eatenCheese);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
