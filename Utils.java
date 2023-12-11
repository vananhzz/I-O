package Week14.Input_Output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Utils {
    /**
     * Do Tran Van Anh 22024530.
     */
    public static String readContentFromFile(String path) throws IOException {
        StringBuilder stringContent = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!(stringContent.length() == 0)) {
                stringContent.append("\n");
            }
            stringContent.append(line);
        }

        bufferedReader.close();

        return stringContent.toString();
    }

    /**
     * Do Tran Van Anh 22024530.
     */
    public static void writeContentToFile(String content, String path) throws IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(path));

        fileWriter.write(content);

        fileWriter.close();
    }

    /**
     * Do Tran Van Anh 22024530.
     */
    public static void appendContentToFile(String content, String path) throws IOException {
        String stringContent = readContentFromFile(path) + "\n" + content;
        BufferedWriter fileWriterAppend = new BufferedWriter(new FileWriter(path));

        fileWriterAppend.write(stringContent);

        fileWriterAppend.close();
    }

    /**
     * Do Tran Van Anh 22024530.
     */
    public static File findFileByName(String folderPath, String fileName) {
        File searchFolder = new File(folderPath);
        List<File> filesInFolder = new ArrayList<>(
                Arrays.asList(Objects.requireNonNull(searchFolder.listFiles()))
        );
        if (!filesInFolder.isEmpty()) {
            for (File file : filesInFolder) {
                if (file.getName().equals(fileName)) {
                    return file;
                }
            }
        }
        return null;
    }
}
