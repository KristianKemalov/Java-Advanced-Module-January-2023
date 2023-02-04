package StreamFilesDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _12_LineNumbers {
    public static void main(String[] args) throws IOException {


        String pathToFile = "C:\\Users\\30694\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        PrintWriter printWriter = new PrintWriter("output_line_numbers.txt");
        int lineNumber = 1;


        for (String line : allLines) {
            printWriter.println(lineNumber + ". " + line);
            lineNumber++;

        }
        printWriter.close();

    }
}
