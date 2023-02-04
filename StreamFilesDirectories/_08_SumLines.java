package StreamFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class _08_SumLines {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\User\\Desktop\\SoftUni\\JavaAdvanced\\StreamFileDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(path));

        allLines.stream().map(line -> line.toCharArray()).forEach(arr -> {
            int sum = 0;
            for (char symbol : arr) {
                sum += (int) symbol;

            }
            System.out.println(sum);
        });

    }
}
