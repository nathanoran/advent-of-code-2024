package day3;

import common.LineReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartOne {
    static String mulRegex = "(mul\\(\\d?\\d?\\d,\\d?\\d?\\d\\))";

    public static void main (String[] args) {
        LineReader lineReader = new LineReader();

        String[] commands = lineReader.readLines("day3/input.txt");

        Pattern p = Pattern.compile(mulRegex);

        int sumOfMuls = 0;

        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];

            Matcher m = p.matcher(command);

            while (m.find()) {
                String mul = command.substring(m.start(), m.end());

                mul = mul.replace("mul(", "");
                mul = mul.replace(")", "");

                String[] multiplicativeStrs = mul.split(",");

                sumOfMuls += Integer.parseInt(multiplicativeStrs[0]) * Integer.parseInt(multiplicativeStrs[1]);
            }
        }

        System.out.println("Sum of Muls: " + sumOfMuls);
    }
    
}
