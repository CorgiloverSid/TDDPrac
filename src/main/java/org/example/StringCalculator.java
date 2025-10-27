package org.example;

import com.sun.source.tree.BindingPatternTree;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;

public class StringCalculator {
    public static String add(String input) {
        if (input == null || input.trim().isEmpty()) {
            return "0";
        }

        String delimiterRegex = "[,\n]"; // default delimiters: comma or newline
        String numbers = input;
        List<String> errors = new ArrayList<>();

        // --- Custom delimiter header ---
        if (input.startsWith("//")) {
            int nl = input.indexOf('\n');
            if (nl == -1) {
                return "Invalid format: missing newline after delimiter.";
            }
            String delimiter = input.substring(2, nl);
            numbers = input.substring(nl + 1);

            // Validate: if wrong separator appears, report error
            for (int i = 0; i < numbers.length(); i++) {
                char c = numbers.charAt(i);
                if ((c == ',' || c == '\n') && !delimiter.equals(String.valueOf(c))) {
                    errors.add("'" + delimiter + "' expected but '" + c + "' found at position " + i);
                }
            }
            delimiterRegex = Pattern.quote(delimiter);
        }

        Pattern multipleDelimiter = Pattern.compile("[,\n]{2,}");
        Matcher m = multipleDelimiter.matcher(numbers);
        if (m.find()) {
            char bad = numbers.charAt(m.start() + 1);
            String badChar = (bad == '\n') ? "\\n" : String.valueOf(bad);
            errors.add("Number expected but '" + badChar + "' found at position " + (m.start() + 1));
        }

        // --- Invalid pattern: comma followed by newline ---
        int badIndex = numbers.indexOf(",\n");
        if (badIndex != -1) {
            errors.add("Number expected but '\\n' found at position " + (badIndex + 1));
        }

        // --- Disallow trailing separator ---
        if (numbers.endsWith(",") || numbers.endsWith("\n") ||
                (input.startsWith("//") && numbers.endsWith(input.substring(2, input.indexOf('\n'))))) {
            errors.add("Number expected but EOF found.");
        }

        // --- Normalize spaces ---
        numbers = numbers.replace(" ", "");

        List<BigDecimal> parsedNumbers = new ArrayList<>();
        try {
            parsedNumbers = Arrays.stream(numbers.split(delimiterRegex))
                    .filter(s -> !s.isEmpty())
                    .map(BigDecimal::new)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            errors.add("Invalid number format.");
        }

        // --- Check for negatives ---
        List<BigDecimal> negatives = parsedNumbers.stream()
                .filter(n -> n.compareTo(BigDecimal.ZERO) < 0)
                .toList();

        if (!negatives.isEmpty()) {
            for (BigDecimal n : negatives) {
                errors.add("Negative not allowed : " + n.toPlainString());
            }
        }

        // --- Return errors if any ---
        if (!errors.isEmpty()) {
            return String.join("\n", errors);
        }

        // --- Sum if no errors ---
        BigDecimal sum = parsedNumbers.stream()
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return sum.stripTrailingZeros().toPlainString();
    }
}
