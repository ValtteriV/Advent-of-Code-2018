import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//TASK: Given a file of lines with a number on each where a number can have a + or a - in front of it,
//Find a sum of the numbers that appears twice when going through the file from start to finish. The file may have to be
//looped over multiple times.
public class PartTwo {

    static int frequency = 0;
    static ArrayList<Integer> visitedFrequencies = new ArrayList<>();
    static int trimValue = -1;  //This is the lowest the frequency drops down on each iteration.


    public static void main(String[] args) {
        String filename = "input/input.txt";
        visitedFrequencies.add(frequency);
        while ((trimValue = readInput(filename)) != Integer.MAX_VALUE) {
            System.out.println("No duplicates found yet, retrying...");
            System.out.println("Current Frequency: " + frequency + ".");
            visitedFrequencies.removeIf(n -> (n < trimValue)); //To speed up the processing each iteration.
        }
    }

    public static int readInput(String filename) {
        String line = null;
        int lowest = frequency;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fr);
            while ((line = bufferedReader.readLine()) != null) {
                frequency += Integer.parseInt(line);
                if (frequency < lowest) lowest = frequency;
                if (visitedFrequencies.contains(frequency)) {
                    System.out.println("The first frequency device reaches twice is " + frequency + ".");
                    return Integer.MAX_VALUE;
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
        return lowest;
    }

}