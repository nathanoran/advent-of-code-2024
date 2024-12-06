package common;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner;

public class LineReader {
    public LineReader() {}

    public String[] readLines(String fileName) {
        ArrayList<String> reports = new ArrayList<String>();

        try {
            File inputFile = new File(fileName);
            Scanner inputReader = new Scanner(inputFile);
            while (inputReader.hasNextLine()) {
                reports.add(inputReader.nextLine());
            }
            inputReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return reports.toArray(new String[0]);
    }
}
