import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class WriteCSV {
    public static void main(String[] args) {

        //  Grading program needs hardcoded filename. Oh, well. "
        String inputFilename = "coords.txt";
        String outputFilename = changeFileExtToCsv(inputFilename);

        // Open files
        Scanner input = openInput(inputFilename);
                PrintWriter output = openOutput(outputFilename);

        // Read input line, replace all spaces with commas,
        //            and write output line
        while (input.hasNextLine()) {
            String nextLine = input.nextLine();
            String mutatedLine = nextLine.replace(' ', ',');
            output.println(mutatedLine);
        }
        input.close();
        output.close();

    }
    /**
     * Changes file extension to ".csv"
     * @param filename
     * @return
     */
    public static String changeFileExtToCsv(String filename) {
        return filename.substring(0,filename.lastIndexOf('.')) + ".csv";
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
    /**
     * Open output for writing
     * @param filename
     * @return
     */
    public static PrintWriter openOutput(String filename) {
        PrintWriter out = null;
        try {
            File outfile = new File(filename);
            out = new PrintWriter(outfile);
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(filename + " could not be found");
            System.exit(0);
        }
        return out;
    }

    /**
     * Get Student Info
     * @return
     */
    public String getIdentificationString() {
        return "Program 5a, Christian James";
    }
}