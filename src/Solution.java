import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.*;

public class Solution {

    ArrayList<String> name = new ArrayList<>();

    public void collectAndWrite() throws IOException {
        // write your code here
        File directory = new File("files");
        File elderFile = new File("src\\elderFile.txt");
        if (!elderFile.exists()) elderFile.createNewFile();
        FileWriter fw = new FileWriter(elderFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        listFilesFolder(directory);
        for (int i = 0; i < name.size(); i++) {
            File file = new File(directory.getPath() + "\\" + name.get(i));
            try {
                bw.write(Files.readString(Paths.get(file.toURI())) + "\n");
            } catch (NoSuchFileException e) {
                e.printStackTrace();
            }
        }
        bw.flush();

    }

    private void listFilesFolder(File directory) {
            File[] files = directory.listFiles();
        for (File file :
                files) {
            if (file.isFile()) {
                name.add(file.getName());
            }
        }

    }
}

