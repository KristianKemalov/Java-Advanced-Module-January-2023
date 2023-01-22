package StreamFilesDirectories;

import java.io.*;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {
        String basePath = "C:\\Users\\User\\Desktop\\SoftUni\\JavaAdvanced\\StreamFileDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = basePath + "\\input.txt";
        String outputPath = basePath + "\\04_integers.txt";

        Scanner reader = new Scanner(new FileInputStream(inputPath));
        PrintStream writer=new PrintStream(new FileOutputStream(outputPath));


        while (reader.hasNext()) {
            if (reader.hasNextInt()) {
                writer.println(reader.nextInt());
            }
            reader.next();

        }
    }
}
