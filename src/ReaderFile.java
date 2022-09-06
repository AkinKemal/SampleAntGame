import java.io.*;
import java.util.ArrayList;

public class ReaderFile {

    ArrayList<String> moveOperation = new ArrayList<>();
    ArrayList<String> moveNumber = new ArrayList<>();

    public static final String fileName = "input.csv";

    public ReaderFile() {

    }

    public void readerFile() {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                String[] arraySplit = line.split(",");

                moveOperation.add(arraySplit[0]);
                moveNumber.add(arraySplit[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}