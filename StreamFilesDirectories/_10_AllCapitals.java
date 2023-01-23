package StreamFilesDirectories;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _10_AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Desktop\\SoftUni\\JavaAdvanced\\StreamFileDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        List<String> allFiles = Files.readAllLines(Path.of(path));

        for (String line : allFiles) {
            writer.write(line.toUpperCase());
            writer.newLine();


        }
        writer.close();
    }
}
