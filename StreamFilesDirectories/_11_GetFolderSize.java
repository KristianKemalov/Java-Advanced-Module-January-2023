package StreamFilesDirectories;

import java.io.File;

public class _11_GetFolderSize {
    public static void main(String[] args) {

        String pathToFolder = "C:\\Users\\30694\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(pathToFolder);

        File[] allFilesInFolder = folder.listFiles();


        int bytes = 0;
        if (allFilesInFolder != null) {
            for (File file : allFilesInFolder) {

                bytes += file.length();
            }
            System.out.println("Folder size: " + bytes);
        }
    }
}