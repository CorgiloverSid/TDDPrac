package org.example;

import com.sun.source.tree.BindingPatternTree;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import static java.lang.String.valueOf;

public class StringCalculator {
    private static final DecimalFormat FORMAT = new DecimalFormat("0.#");
    public static String add(String input) {
        if (input == null || input.isEmpty()) return "0";

        int errorIndex = input.indexOf(",\n");
        if (errorIndex != -1) return "Number expected but '\n' found at position " + (errorIndex + 1);

        String replaceNewlineWithComma = input.replace("\n", ",");

        if (replaceNewlineWithComma.endsWith(",")) return "Number expected but EOF found";

        String[] parts = replaceNewlineWithComma.split(",");
        float sum = 0;
        for (String p : parts) {
            sum += Float.parseFloat(p);
        }

        if (sum == Math.rint(sum)) return String.valueOf((int) sum);
        return FORMAT.format(sum);
    }
}


