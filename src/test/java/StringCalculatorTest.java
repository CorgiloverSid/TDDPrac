import org.example.StringCalculator;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    // --- Basic cases ---
    @Test
    public void emptyStringReturnsZero() {
        assertEquals("0", StringCalculator.add(""));
    }

    @Test
    public void singleNumberReturnsSame() {
        assertEquals("5", StringCalculator.add("5"));
    }

    @Test
    public void singleDecimalReturnsSame() {
        assertEquals("2.1", StringCalculator.add("2.1"));
    }

    // --- Multiple numbers ---
    @Test
    public void commaSeparatedNumbersReturnSum() {
        assertEquals("6", StringCalculator.add("1,2,3"));
    }

    @Test
    public void decimalNumbersReturnSum() {
        assertEquals("3.5", StringCalculator.add("1.3, 2.2"));
    }

    @Test
    public void manyNumbersReturnSum() {
        assertEquals("82", StringCalculator.add("1, 2, 3, 4, 5, 6, 19, 19, 23"));
    }

    // --- Newline handling ---
    @Test
    public void newlineActsAsSeparator() {
        assertEquals("6", StringCalculator.add("1\n2,3"));
    }

    @Test
    public void newlineImmediatelyAfterCommaIsInvalid() {
        assertEquals("Number expected but '\\n' found at position 2",
                StringCalculator.add("1,\n2,3"));
    }

    // --- Trailing separators ---
    @Test
    public void trailingCommaIsInvalid() {
        assertEquals("Number expected but EOF found.",
                StringCalculator.add("1,2,"));
    }

    @Test
    public void trailingNewlineIsInvalid() {
        assertEquals("Number expected but EOF found.",
                StringCalculator.add("1,2\n"));
    }

    // --- Custom delimiters ---
    @Test
    public void customDelimiterSemicolon() {
        assertEquals("3", StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void customDelimiterPipe() {
        assertEquals("6", StringCalculator.add("//|\n1|2|3"));
    }

    @Test
    public void customDelimiterWord() {
        assertEquals("5", StringCalculator.add("//ba\n2ba3"));
    }

    @Test
    public void wrongDelimiterReportsError() {
        assertEquals("'|' expected but ',' found at position 3" + "\nInvalid number format.",
                StringCalculator.add("//|\n1|2,3"));
    }

    @Test
    public void trailingCustomDelimiterIsInvalid() {
        assertEquals("Number expected but EOF found.",
                StringCalculator.add("//;\n1;2;"));
    }

    @Test
    public void testSingleNegative() {
        assertEquals("Negative not allowed : -1", StringCalculator.add("-1,2"));
    }

    @Test
    public void testMultipleNegatives() {
        assertEquals("Negative not allowed : -4\nNegative not allowed : -5", StringCalculator.add("2,-4,-5"));
    }

    @Test
    public void testMultipleErrors() {
        String expected = "Number expected but ',' found at position 3\nNegative not allowed : -1";
        assertEquals(expected, StringCalculator.add("-1,,2"));
    }

    @Test
    public void testMultipleErrorsWithTwoNegatives() {
        String expected = "Number expected but ',' found at position 3\nNegative not allowed : -1\nNegative not allowed : -2";
        assertEquals(expected, StringCalculator.add("-1,,-2"));
    }

    @Test
    public void testMultiplyTwoNumbers() {
        assertEquals("4", StringCalculator.multiply("2,2"));
    }
}
