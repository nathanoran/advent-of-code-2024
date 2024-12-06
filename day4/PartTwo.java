package day4;

import common.LineReader;

public class PartTwo {
    public static void main(String[] args) {
        LineReader reader = new LineReader();

        String[] matrix = reader.readLines("day4/input.txt");

        int foundXMASs = 0;

        // The Center 'A' of an X-MAS cannot be on the outside edge of the matrix
        for (int i = 1; i < matrix.length - 1; i++) {
            String currentLine = matrix[i];
            for (int j = 1; j < currentLine.length() - 1; j++) {
                foundXMASs += countXMASs(matrix, i, j);
            }
        }

        System.out.println("Found XMAS\'s: " + foundXMASs);
    }

    private static int countXMASs(String[] matrix, int i, int j) {
        String currentLine = matrix[i];
        int foundXMASs = 0;
        if (currentLine.charAt(j) == 'A') {
            if (isXMAS(matrix, i, j)) {
                foundXMASs += 1;
            }
        }
        return foundXMASs;
    }

    /*
     * M S
     *  A
     * M S
     */
    private static boolean isXMAS(String[] matrix, int i, int j) {
        int[] topLeftCoords = { i - 1, j - 1 };
        int[] topRightCoords = { i - 1, j + 1 };
        int[] bottomLeftCoords = { i + 1, j - 1 };
        int[] bottomRightCoords = { i + 1 , j + 1 };

        char topLeftChar = matrix[topLeftCoords[0]].charAt(topLeftCoords[1]);
        char topRightChar = matrix[topRightCoords[0]].charAt(topRightCoords[1]);
        char bottomLeftChar = matrix[bottomLeftCoords[0]].charAt(bottomLeftCoords[1]);
        char bottomRightChar = matrix[bottomRightCoords[0]].charAt(bottomRightCoords[1]);

        boolean slashMAS = false;
        boolean backSlashMAS = false;

        if (
            (bottomLeftChar == 'M' && topRightChar == 'S') ||
            (bottomLeftChar == 'S' && topRightChar == 'M')
        ) {
            slashMAS = true;
        }

        if (
            (bottomRightChar == 'M' && topLeftChar == 'S') ||
            (bottomRightChar == 'S' && topLeftChar == 'M')
        ) {
            backSlashMAS = true;
        }

        return slashMAS && backSlashMAS;
    }

}
