package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {

    final static String PATH = "";

    public static void write(String fileName, String data) {

        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(PATH + file)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Error write file!");
        }
    }

    public static String read(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(PATH + fileName)));
        } catch (IOException e) {
            System.out.println("Error read file!");
            return null;
        }
    }
}
