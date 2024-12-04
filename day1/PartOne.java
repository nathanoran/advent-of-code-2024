package day1;

import common.MergeSorter;

public class PartOne {

    public static void main(String[] args) {
        System.out.println("Hello World");

        ListReader reader = new ListReader();
        MergeSorter sorter = new MergeSorter();

        Integer[][] lists;
        lists = reader.readLists("day1/input.txt");

        Integer[] sortedA = sorter.sort(lists[0]);
        Integer[] sortedB = sorter.sort(lists[1]);

        Integer totalDistance = 0;

        for (int i = 0; i < sortedA.length; i++) {
            totalDistance += Math.abs(sortedA[i] - sortedB[i]);
        }

        System.out.println("Expected Distance: 1590491");
        System.out.println("Total Distance: " + totalDistance);
    }
}
