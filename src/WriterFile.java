import java.io.*;

public class WriterFile {

    public static final String fileName = "output.txt";

    public WriterFile() {

    }

    public void writerFile(String str) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(str);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}