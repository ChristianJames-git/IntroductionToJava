import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class BogoSort {

    public ArrayList<Integer> input = new ArrayList<Integer>();
    public long randomSeed;
    public int noOfRuns;

    public BogoSort() {
        System.out.println("BOGO Sort, Christian James");
    }
    public BogoSort(String inFile) {
        this();
        readFromFile(inFile);
        printList('i');
        sort();
        printList('s');
    }
    private void readFromFile(String inFile) {
        Scanner fromFile = openInput(inFile);
        try {
            String seed = fromFile.nextLine();
            this.randomSeed = Integer.parseInt(seed);
//            String initialInput = fromFile.nextLine();
//            String[] split = initialInput.split(",");
//            for (String number : split) {
//                input.add(Integer.parceInt(number));
//            }
            fromFile.useDelimiter("\\D");
            for (int i = 0; i < 10; i++) {
                input.add(fromFile.nextInt());
            }
        }
        catch (Exception a) {
            System.out.println("Incorrect Input Type");
            System.exit(0);
        }
        fromFile.close();
    }
    private void sort () {
        Random randomArray = new Random(randomSeed);
        int randomNumber;
        while (isNotSorted()) {
            for (int i = 0; i < input.size(); i++) {
                randomNumber = randomArray.nextInt(input.size());
                Collections.swap(input, i, randomNumber);
            }
        }
    }
    private boolean isNotSorted() {
        for (int i = 0; i < input.size()-1; i++) {
            if (input.get(i) > input.get(i+1)) {
                noOfRuns++;
                return true;
            }
        }
        return false;
    }
    private void printList(char a) {
        if (a == 'i')
            System.out.print("Initial List: ");
        else if (a == 's')
            System.out.print("Sorted List in " + noOfRuns + " attempt(s): ");
        for (int i = 0; i < input.size()-1; i++) {
            System.out.print(input.get(i) + ",");
        }
        System.out.println(input.get(input.size()-1));
    }
    /**
     * Open input for reading
     * @param filename
     * @return
     */
    public static Scanner openInput(String filename) {
        Scanner in = null;
        try {
            File infile = new File(filename);
            in = new Scanner(infile);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(filename + " could not be found");
            System.exit(0);
        }
        return in;
    }
}