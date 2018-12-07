import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class PartOne {

    static String filename = "input/input.txt";

    public static void main(String[] args) {
        int twos = 0;
        int threes = 0;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fr);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                boolean two = true;
                boolean three = true;
                char[] brokendown = line.toCharArray();
                Arrays.sort(brokendown);
                int consecutives = 0;
                char current = 'a';
                for (char ch : brokendown) {
                    if (consecutives == 0) {
                        current = ch;
                        consecutives = 1;
                    } else if (ch != current) {
                        if (consecutives == 2 && two) {
                            two = false;
                            twos += 1;
                        } else if (consecutives == 3 && three) {
                            three = false;
                            threes += 1;
                        }
                        current = ch;
                        consecutives = 1;
                    } else {
                        consecutives += 1;
                    }
                }
            }
            System.out.println(twos * threes);

        } catch (Exception e) {
            System.out.println("Error reading file " + filename);
            e.printStackTrace();
        }
    }
}
