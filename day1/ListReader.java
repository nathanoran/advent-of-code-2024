package day1;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner;

public class ListReader {
    public ListReader() {}

    public Integer[][] readLists(String fileName) {
        ArrayList<Integer> listA = new ArrayList<Integer>();
        ArrayList<Integer> listB = new ArrayList<Integer>();

        try {
            File inputFile = new File(fileName);
            Scanner inputReader = new Scanner(inputFile);
            Integer i = 0;
            while (inputReader.hasNext()) {
                Integer data = inputReader.nextInt();
                if (i == 0) {
                    listA.add(data);
                } else {
                    listB.add(data);
                }
                i = (i + 1) % 2;
            }
            inputReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Integer[] arrayA = listA.toArray(new Integer[0]);
        Integer[] arrayB = listB.toArray(new Integer[0]);

        Integer[][] returnArr = new Integer[2][arrayA.length];
        returnArr[0] = arrayA;
        returnArr[1] = arrayB;

        return returnArr;
    }
}
