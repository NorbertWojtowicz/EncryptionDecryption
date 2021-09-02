package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Message {
    public static String getData(File sourceFile) {
        StringBuilder data = new StringBuilder();
        try (Scanner scanner = new Scanner(sourceFile)) {
            while (scanner.hasNext()) {
                data.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data.toString();
    }

    public static void writeToFile(File outFile, String data) {
        try (FileWriter fileWriter = new FileWriter(outFile)) {
            fileWriter.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
