package day2;

import java.util.Arrays;

public class PartTwo {
    public static void main(String[] args) {
        ReportReader reader = new ReportReader();

        int[][] reports = reader.readReports("day2/input.txt");

        int totalSafeReports = 0;

        for (int i = 0; i < reports.length; i++) {
            int[] report = reports[i];
            boolean reportIsSafe = false;
            for (int skipIndex = -1; skipIndex < report.length && !reportIsSafe; skipIndex++) {
                reportIsSafe = isReportSafe(report, skipIndex);
            }
            if (reportIsSafe) {
                totalSafeReports++;
            } else {
                System.out.println(Arrays.toString(reports[i]));
            }
        }

        System.out.println("Total safe reports: " + totalSafeReports);
    }

    protected enum ReportDirection {
        ASCENDING,
        DESCENDING,
        STAGNANT,
    }

    protected static boolean isReportSafe(int[] report, int skipIndex) {
        if (report.length <= 2) {
            return true;
        }

        int initialDiff = report[1] - report[0];
        int iteratorStart = 2;
        int prev = 1;

        if (skipIndex == 0) {
            initialDiff = report[2] - report[1];
            iteratorStart = 3;
            prev = 2;
        } else if (skipIndex == 1) {
            initialDiff = report[2] - report[0];
            iteratorStart = 3;
            prev = 2;
        }

        boolean reportIsSafe = meetsSafetyThreshold(initialDiff);
        ReportDirection reportDirection = getDiffDirection(initialDiff);

        for (int i = iteratorStart; i < report.length && reportIsSafe; i++) {
            if (i != skipIndex) {
                int diff = report[i] - report[prev];
                if (!meetsSafetyThreshold(diff) || reportDirection != getDiffDirection(diff)) {
                    reportIsSafe = false;
                }
                prev = i;
            }
        }

        return reportIsSafe;
    }

    protected static boolean meetsSafetyThreshold(int diff) {
        int magnitude = Math.abs(diff);
        return magnitude <= 3 && getDiffDirection(diff) != ReportDirection.STAGNANT;
    }

    protected static ReportDirection getDiffDirection(int diff) {
        if (diff > 0) {
            return ReportDirection.ASCENDING;
        } else if (diff < 0) {
            return ReportDirection.DESCENDING;
        } else {
            return ReportDirection.STAGNANT;
        }
    }
}
