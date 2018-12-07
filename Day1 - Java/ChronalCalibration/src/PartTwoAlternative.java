import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

//TASK: Given a file of lines with a number on each where a number can have a + or a - in front of it,
//Find a sum of the numbers that appears twice when going through the file from start to finish. The file may have to be
//looped over multiple times.

//This program uses a binary tree to store the values instead of an ArrayList. This cuts the time complexity from O(n²)
//to O(n log n) in an optimal case. The values aren't placed too often to the left side of the tree so it is probably
//not extremely close to the optimal case but the performance impact is still massive.
public class PartTwoAlternative {

    public static class Node {
        int value;
        Node left = null;
        Node right = null;

        public Node(int value) {
            this.value = value;
        }

        public boolean findOrInsertValue(int value) {
            if (value == this.value) return true;
            if (value < this.value) {
                if (this.left != null) return this.left.findOrInsertValue(value);
                this.left = new Node(value);
                return false;
            }
            if (this.right != null) return this.right.findOrInsertValue(value);
            this.right = new Node(value);
            return false;
        }
    }

    static int frequency = 0;
    static Node root;


    public static void main(String[] args) {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        String filename = "input/input.txt";
        root = new Node(frequency);
        while (!readInput(filename)) {
            System.out.println("No duplicates found yet, retrying...");
            System.out.println("Current Frequency: " + frequency + ".");
        }
    }

    public static boolean readInput(String filename) {
        String line = null;
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fr);
            while ((line = bufferedReader.readLine()) != null) {
                frequency += Integer.parseInt(line);
                if (root.findOrInsertValue(frequency)) {
                    System.out.println("The first frequency device reaches twice is " + frequency + ".");
                    return true;
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