package org.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        StringCalculator.add()
//        String input = "//;\n1;2;3";
//        String testInput = "1;2;3";
//        System.out.println(testInput.length());
//
//        String delimiterRegex = "[,\n]"; // default: comma or newline
//        String numbers = input;
//
//        // Custom delimiter header
//        if (input.startsWith("//")) {
//            int nl = input.indexOf('\n');
//            if (nl == -1) {
//                System.out.println("Number expected but EOF found.");
//            }
//            String delimiter = input.substring(2, nl);
//            numbers = input.substring(nl + 1);
//
//            // Validate: if wrong separator appears, report error
//            for (int i = 0; i < numbers.length(); i++) {
//                System.out.println(numbers.length());
//                char c = numbers.charAt(i);
//                if ((c == ',' || c == '\n') && !delimiter.equals(String.valueOf(c))) {
//                    System.out.println("'" + delimiter + "' expected but '" + c + "' found at position " + i + ".");
//                }
//            }
//
//            // Escape regex special chars if needed
//            delimiterRegex = Pattern.quote(delimiter);
//        }
//
//        // Disallow trailing separator
//        if (numbers.endsWith(",") || numbers.endsWith("\n") || numbers.endsWith(input.startsWith("//") ? input.substring(2, input.indexOf('\n')) : "")) {
//            System.out.println("Number expected but EOF found.");
//        }
//
//        try {
//            BigDecimal sum = Arrays.stream(numbers.split(delimiterRegex))
//                    .map(BigDecimal::new)
//                    .reduce(BigDecimal.ZERO, BigDecimal::add);
//
//            System.out.println(sum.stripTrailingZeros().toPlainString());
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid number format.");
//        }
//    }
//
//
//    public static int whenMetacharactersNotEscaped_thenNoMatchesFound(String patternStr) {
//        String literalPatternStr = Pattern.quote(patternStr);
//        String dollarAmounts = "$100.25, $100.50, $150.50, $100.50, $100.75";
//        Pattern pattern = Pattern.compile(literalPatternStr);
//        Matcher matcher = pattern.matcher(dollarAmounts);
//
//        int matches = 0;
//        while (matcher.find()) {
//            matches++;
//        }
//        return matches;
    }



}
