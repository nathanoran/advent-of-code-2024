package day3;

import common.LineReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartTwo {
    static String mulRegex = "(mul\\(\\d?\\d?\\d,\\d?\\d?\\d\\))";
    static String doRegex = "(do\\(\\))";
    static String doNotRegex = "(don't\\(\\))";
    static String Regex = mulRegex + "|" + doRegex + "|" + doNotRegex;

    public static void main (String[] args) {
        LineReader lineReader = new LineReader();

        String[] commands = lineReader.readLines("day3/input.txt");

        Pattern p = Pattern.compile(Regex);

        int sumOfMuls = 0;

        boolean performMul = true;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            Matcher m = p.matcher(command);

            while (m.find()) {
                String foundControl = command.substring(m.start(), m.end());

                switch (foundControl) {
                    case "do()":
                        performMul = true;
                        break;
                    case "don't()":
                        performMul = false;
                        break;
                    default:
                        if (performMul) {
                            foundControl = foundControl.replace("mul(", "");
                            foundControl = foundControl.replace(")", "");
            
                            String[] multiplicativeStrs = foundControl.split(",");
            
                            sumOfMuls += Integer.parseInt(multiplicativeStrs[0]) * Integer.parseInt(multiplicativeStrs[1]);
                        }
                        break;
                }
            }
        }

        System.out.println("Sum of Muls: " + sumOfMuls);
    }
    
}
