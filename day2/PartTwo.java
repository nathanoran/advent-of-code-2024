package day2;

import java.util.Arrays;

public class PartTwo {
    public static void main(String[] args) {
        ReportReader reader = new ReportReader();

        int[][] reports = reader.readReports("day2/input.txt");

        int totalSafeReports = 0;

        for (int i = 0; i < reports.length; i++) {
            if (isReportSafe(reports[i]) == true) {
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
    }

    protected static boolean isReportSafe(int[] report) {
        int SAFETY_THRESHOLD = 3;

        if (report.length <= 2) {
            return true;
        }

        boolean skipUsed = false;
        int initialDiff = report[1] - report[0];
        boolean reportIsSafe = Math.abs(initialDiff) <= SAFETY_THRESHOLD && initialDiff != 0;
        int iteratorStart = 2;
        int prev = 1;

        if (!reportIsSafe) {
            // If the first two elements do not observe the safety threshold, 
            // we don't know yet if the first or second element should be removed.
            int diff2to0 = report[2] - report[0];
            int diff2to1 = report[2] - report[1];

            if (report.length == 3) {
                // If the report is only of length 3, then we can just determine if either the 1st or 2nd element can be removed at this point.
                return (Math.abs(diff2to0) <= SAFETY_THRESHOLD && diff2to0 != 0) || (Math.abs(diff2to1) <= SAFETY_THRESHOLD && diff2to1 != 0);
            }

            // If the report is of length 4 or greater, then we can us the second pair to check for the expected report direction (if the report is safe)
            if (Math.abs(diff2to0) <= SAFETY_THRESHOLD && diff2to0 != 0) {
                initialDiff = diff2to0;
            } else if (Math.abs(diff2to1) <= SAFETY_THRESHOLD && diff2to1 != 0) {
                initialDiff = diff2to1;
            } else {
                // The report requires more than one skip to be considered "safe"
                return false;
            }

            reportIsSafe = true;
            skipUsed = true;
            prev = 2;
            iteratorStart = 3;
        }

        ReportDirection reportDirection;
        if (initialDiff > 0) {
            reportDirection = ReportDirection.ASCENDING;
        } else if (initialDiff < 0) {
            reportDirection = ReportDirection.DESCENDING;
        } else {
            return false;
        }

        for (int i = iteratorStart; i < report.length && reportIsSafe == true; i++) {
            int diff = report[i] - report[prev];
            if (reportDirection == ReportDirection.ASCENDING && diff <= 0) {
                reportIsSafe = false;
            } else if (reportDirection == ReportDirection.DESCENDING && diff >= 0) {
                reportIsSafe = false;
            } else if (Math.abs(diff) > SAFETY_THRESHOLD) {
                reportIsSafe = false;
            }

            if (reportIsSafe) {
                // if this diff is safe, then we set the previous value to this iterator
                prev = i;
            } else if (!skipUsed) {
                // skip this i by not incrementing prev
                reportIsSafe = true;
                skipUsed = true;
            }
        }

        return reportIsSafe;
    }
}
