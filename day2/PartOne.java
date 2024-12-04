package day2;

public class PartOne {
    public static void main(String[] args) {
        ReportReader reader = new ReportReader();

        int[][] reports = reader.readReports("day2/input.txt");

        int totalSafeReports = 0;

        for (int i = 0; i < reports.length; i++) {
            if (isReportSafe(reports[i], 3) == true) {
                totalSafeReports++;
            }
        }

        System.out.println("Total safe reports: " + totalSafeReports);
    }

    protected enum ReportDirection {
        ASCENDING,
        DESCENDING,
    }

    protected static boolean isReportSafe(int[] report, int safetyThreshold) {
        int initialDiff = report[1] - report[0];
        ReportDirection reportDirection;
        if (initialDiff > 0) {
            reportDirection = ReportDirection.ASCENDING;
        } else if (initialDiff < 0) {
            reportDirection = ReportDirection.DESCENDING;
        } else {
            return false;
        }

        boolean reportIsSafe = Math.abs(initialDiff) <= safetyThreshold;

        if (report.length <= 2) {
            return reportIsSafe;
        }

        for (int i = 2; i < report.length && reportIsSafe == true; i++) {
            int diff = report[i] - report[i - 1];
            if (reportDirection == ReportDirection.ASCENDING && diff <= 0) {
                reportIsSafe = false;
            } else if (reportDirection == ReportDirection.DESCENDING && diff >= 0) {
                reportIsSafe = false;
            } else if (Math.abs(diff) > safetyThreshold) {
                reportIsSafe = false;
            }
        }

        return reportIsSafe;
    }
}
