import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class PartTwo {

    static int frequency = 0;
    static ArrayList<Integer> visitedFrequencies = new ArrayList<>();
    static int magicNumber = -329; //This is the lowest the frequency drops down on each iteration.


    public static void main(String[] args) {
        String filename = "input/input.txt";
        visitedFrequencies.add(frequency);
        while (!readInput(filename)) {
            System.out.println("No duplicates found yet, retrying...");
            System.out.println("Current Frequency: " + frequency + ".");
            visitedFrequencies.removeIf(n -> (n < (frequency+magicNumber))); //To speed up the processing each iteration.
        }
    }

    public static boolean readInput(String filename) {
        String line = null;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fr);
            while ((line = bufferedReader.readLine()) != null) {
                frequency += Integer.parseInt(line);
                if (visitedFrequencies.contains(frequency)) {
                    System.out.println("The first frequency device reaches twice is " + frequency + ".");
                    return true;
                } else {
                    visitedFrequencies.add(frequency);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error reading file '" + filename + "'.");
            e.printStackTrace();
            System.exit(1);
        }
        return false;
    }

}