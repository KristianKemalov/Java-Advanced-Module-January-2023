package StreamFilesDirectories;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _13_WordCount {
    public static void main(String[] args) throws IOException {
        String pathToFile = "C:\\Users\\User\\Desktop\\SoftUni\\JavaAdvanced\\StreamFileDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathToFile));

        Map<String, Integer> countWords = new HashMap<>();

        for (String line : allLines) {

            String[] wordsOnRow = line.split(" ");
            Arrays.stream(wordsOnRow).forEach(word -> {
                countWords.put(word, 0);
            });
        }
        String pathToText = "C:\\Users\\User\\Desktop\\SoftUni\\JavaAdvanced\\StreamFileDirectories\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        List<String> allTextLines = Files.readAllLines(Path.of(pathToText));
        for (String line : allTextLines) {


            String[] wordsOnLine = line.split(" ");
            for (String word : wordsOnLine) {
                if (countWords.containsKey(word)) {
                    countWords.put(word, countWords.get(word) + 1);
                }
            }

            PrintWriter printWriter = new PrintWriter("result.txt");
            countWords.entrySet().stream()
                    .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                    .forEach(entry -> printWriter.println(entry.getKey() + " - " + entry.getValue()));
            printWriter.close();


        }

    }
}
