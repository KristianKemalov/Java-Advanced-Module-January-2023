package StreamFilesDirectories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class _01_ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String path = "C:\\Users\\User\\Desktop\\SoftUni\\JavaAdvanced\\StreamFileDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (InputStream inputStream = new FileInputStream(path)) {
            int readByte = inputStream.read();

            while (readByte >= 0) {
                System.out.print(Integer.toBinaryString(readByte) + " ");


                readByte = inputStream.read();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
