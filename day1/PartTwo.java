package day1;

import java.util.HashMap;

public class PartTwo {
    public static void main(String[] args) {
        System.out.println("Hello World");

        ListReader reader = new ListReader();

        Integer[][] lists;
        lists = reader.readLists("day1/input.txt");

        Integer[] listA = lists[0];
        HashMap<Integer, Integer> listBOccurences = countValueOccurences(lists[1]);

        Integer totalDistance = 0;

        for (int i = 0; i < listA.length; i++) {
            if (listBOccurences.get(listA[i]) != null) {
                totalDistance += listA[i] * listBOccurences.get(listA[i]);
            }
        }

        System.out.println("Total Distance: " + totalDistance);
    }

    protected static HashMap<Integer, Integer> countValueOccurences(Integer[] values) {
        HashMap<Integer, Integer> valueOccurences = new HashMap<Integer, Integer>();

        for (int i = 0; i < values.length; i++) {
            if (valueOccurences.get(values[i]) == null) {
                valueOccurences.put(values[i], 1);
            } else {
                valueOccurences.put(values[i], valueOccurences.get(values[i]) + 1);
            }
        }

        return valueOccurences;
    }
}
