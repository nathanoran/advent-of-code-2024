package day1;

import java.io.File; // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.ArrayList;
import java.util.Scanner;

import common.MergeSorter;

public class PartOne {

    public static void main(String[] args) {
        System.out.println("Hello World");

        ArrayList<Integer> listA = new ArrayList<Integer>();
        ArrayList<Integer> listB = new ArrayList<Integer>();
        MergeSorter sorter = new MergeSorter();

        try {
            File inputFile = new File("day1/input.txt");
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

        Integer[] sortedA = sorter.sort(listA.toArray(new Integer[0]));
        Integer[] sortedB = sorter.sort(listB.toArray(new Integer[0]));

        Integer totalDistance = 0;

        for (int i = 0; i < sortedA.length; i++) {
            totalDistance += Math.abs(sortedA[i] - sortedB[i]);
        }

        System.out.println("Total Distance: " + totalDistance);
    }
}
