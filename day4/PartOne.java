package day4;

import common.LineReader;

public class PartOne {
    public static void main(String[] args) {
        LineReader reader = new LineReader();

        String[] matrix = reader.readLines("day4/input.txt");

        int foundXMASs = 0;

        for (int i = 0; i < matrix.length; i++) {
            String currentLine = matrix[i];
            for (int j = 0; j < currentLine.length(); j++) {
                foundXMASs += countXMASs(matrix, i, j);
            }
        }

        System.out.println("Found XMAS\'s: " + foundXMASs);
    }

    private static int countXMASs(String[] matrix, int i, int j) {
        String currentLine = matrix[i];
        int foundXMASs = 0;
        if (currentLine.charAt(j) == 'X') {
            if (isReverseUpXMAS(matrix, i, j)) {
                foundXMASs += 1;
            }
            if (isReverseXMAS(matrix, i, j)) {
                foundXMASs += 1;
            }
            if (isReverseDownXMAS(matrix, i, j)) {
                foundXMASs += 1;
            }
            if (isReverseVerticalXMAS(matrix, i, j)) {
                foundXMASs += 1;
            }
            if (isVerticalXMAS(matrix, i, j)) {
                foundXMASs += 1;
            }
            if (isUpXMAS(matrix, i, j)) {
                foundXMASs += 1;
            }
            if (isXMAS(matrix, i, j)) {
                foundXMASs += 1;
            }
            if (isDownXMAS(matrix, i, j)) {
                foundXMASs += 1;
            }
        }
        return foundXMASs;
    }

    /*
     * S
     *  A
     *   M
     *    X
     */
    private static boolean isReverseUpXMAS(String[] matrix, int i, int j) {
        int[] xCoords = { i, j };
        int[] mCoords = { i - 1, j - 1 };
        int[] aCoords = { i - 2, j - 2 };
        int[] sCoords = { i - 3, j - 3 };

        return XMASfound(matrix, xCoords, mCoords, aCoords, sCoords);
    }

    /*
     * SAMX
     */
    private static boolean isReverseXMAS(String[] matrix, int i, int j) {
        int[] xCoords = { i, j };
        int[] mCoords = { i, j - 1 };
        int[] aCoords = { i, j - 2 };
        int[] sCoords = { i, j - 3 };

        return XMASfound(matrix, xCoords, mCoords, aCoords, sCoords);
    }

    /*
     *    X
     *   M
     *  A
     * S
     */
    private static boolean isReverseDownXMAS(String[] matrix, int i, int j) {
        int[] xCoords = { i, j };
        int[] mCoords = { i + 1, j - 1 };
        int[] aCoords = { i + 2, j - 2 };
        int[] sCoords = { i + 3, j - 3 };

        return XMASfound(matrix, xCoords, mCoords, aCoords, sCoords);
    }

    /*
     * S
     * A
     * M
     * X
     */
    private static boolean isReverseVerticalXMAS(String[] matrix, int i, int j) {
        int[] xCoords = { i, j };
        int[] mCoords = { i - 1, j };
        int[] aCoords = { i - 2, j };
        int[] sCoords = { i - 3, j };

        return XMASfound(matrix, xCoords, mCoords, aCoords, sCoords);
    }

    /*
     * X
     * M
     * A
     * S
     */
    private static boolean isVerticalXMAS(String[] matrix, int i, int j) {
        int[] xCoords = { i, j };
        int[] mCoords = { i + 1, j };
        int[] aCoords = { i + 2, j };
        int[] sCoords = { i + 3, j };

        return XMASfound(matrix, xCoords, mCoords, aCoords, sCoords);
    }

    /*
     *    S
     *   A
     *  M
     * X
     */
    private static boolean isUpXMAS(String[] matrix, int i, int j) {
        int[] xCoords = { i, j };
        int[] mCoords = { i - 1, j + 1 };
        int[] aCoords = { i - 2, j + 2 };
        int[] sCoords = { i - 3, j + 3 };

        return XMASfound(matrix, xCoords, mCoords, aCoords, sCoords);
    }

    /*
     * XMAS
     */
    private static boolean isXMAS(String[] matrix, int i, int j) {
        int[] xCoords = { i, j };
        int[] mCoords = { i, j + 1 };
        int[] aCoords = { i, j + 2 };
        int[] sCoords = { i, j + 3 };

        return XMASfound(matrix, xCoords, mCoords, aCoords, sCoords);
    }

    /*
     * X
     *  M
     *   A
     *    S
     */
    private static boolean isDownXMAS(String[] matrix, int i, int j) {
        int[] xCoords = { i, j };
        int[] mCoords = { i + 1, j + 1 };
        int[] aCoords = { i + 2, j + 2 };
        int[] sCoords = { i + 3, j + 3 };

        return XMASfound(matrix, xCoords, mCoords, aCoords, sCoords);
    }

    private static boolean XMASfound(String[] matrix, int[] xCoords, int[] mCoords, int[] aCoords, int[] sCoords) {
        if (
            sCoords[0] >= 0 &&
            sCoords[0] < matrix.length &&
            sCoords[1] >= 0 &&
            sCoords[1] < matrix[0].length()
        ) {
            return matrix[xCoords[0]].charAt(xCoords[1]) == 'X' &&
                matrix[mCoords[0]].charAt(mCoords[1]) == 'M' &&
                matrix[aCoords[0]].charAt(aCoords[1]) == 'A' &&
                matrix[sCoords[0]].charAt(sCoords[1]) == 'S';
        }
        return false;
    }
}
