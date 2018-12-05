import java.io.BufferedReader;
import java.io.FileReader;

public class PartOne {

    public static void main(String[] args) {
        String filename = "input/input.txt";
        String line = null;
        int frequency = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fr);

            while ((line = bufferedReader.readLine()) != null) {
                frequency += Integer.parseInt(line);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error reading file '" + filename + "'.");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Changes in the frequency sum up to " + frequency + ".");
    }

}
