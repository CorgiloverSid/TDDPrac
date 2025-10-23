import org.example.StringCalculator;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringCalculatorTest {
    @Test
    public void testEmptySpaceReturns0() {
        assertEquals("0", StringCalculator.add(""));
    }

    @Test
    public void testReturnsSameNumber() {
        assertEquals("1", StringCalculator.add("1"));
    }

    @Test
    public void testReturnsWholeSum() {
        assertEquals("1", StringCalculator.add("1"));
    }

    @Test
    public void testReturnsDecimalSum() {
        assertEquals("3.5", StringCalculator.add("1.3, 2.2"));
    }

    @Test
    public void testUnknownAmountOfArguments() {
        assertEquals("82", StringCalculator.add("1, 2, 3, 4, 5, 6, 19, 19, 23"));
    }

    @Test
    public void testNewlineStillCalculates() {
        assertEquals("6", StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testNewlineWrongPositionDoesNotCalculate() {
        assertEquals("Number expected but '\n' found at position 2", StringCalculator.add("1,\n2,3"));
    }

    @Test
    public void errorEOFPosition() {
        assertEquals("Number expected but EOF found", StringCalculator.add("1,2\n,"));
    }
}
