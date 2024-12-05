package day2;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ReportReader {
    public ReportReader() {}

    public int[][] readReports(String fileName) {
        ArrayList<int[]> reports = new ArrayList<int[]>();

        try {
            File inputFile = new File(fileName);
            Scanner inputReader = new Scanner(inputFile);
            while (inputReader.hasNextLine()) {
                String data = inputReader.nextLine();
                int[] ints = Arrays.stream(data.split("\s+")).mapToInt(Integer::parseInt).toArray();
                reports.add(ints);
            }
            inputReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return reports.toArray(new int[0][]);
    }
}
