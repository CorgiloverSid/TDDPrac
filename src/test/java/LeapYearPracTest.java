import org.example.LeapYear;
import org.junit.Assert;
import org.junit.Test;

public class LeapYearPracTest {

    @Test
    public void yearIsDivisibleBy400AndIsLeapYear() {
        Assert.assertTrue(LeapYear.isLeapYear(1200));
        Assert.assertTrue(LeapYear.isLeapYear(2000));
    }

    @Test
    public void yearIsDivisibleBy100AndIsNotLeapYear() {
        Assert.assertFalse(LeapYear.isLeapYear(500));
        Assert.assertFalse(LeapYear.isLeapYear(1000));
    }

    @Test
    public void yearIsDivisibleBy4AndIsLeapYear() {
        Assert.assertTrue(LeapYear.isLeapYear(1200));
        Assert.assertTrue(LeapYear.isLeapYear(1204));
    }

    @Test
    public void yearIsNotDivisibleBy4SoIsNotLeapYear() {
        Assert.assertFalse(LeapYear.isLeapYear(1500));
        Assert.assertFalse(LeapYear.isLeapYear(1700));
    }
}
