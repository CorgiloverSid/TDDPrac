import org.example.FizzBuzz;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FizzBuzzTest {

    @Test
    public void testMultiplesOfFive() {
        assertEquals("buzz", FizzBuzz.fizzBuzzCalculation(10));
    }

    @Test
    public void testNegativeMultiplesOfFive() {
        assertEquals("buzz", FizzBuzz.fizzBuzzCalculation(-10));
    }

    @Test
    public void testContainsFive() {
        assertEquals("buzz", FizzBuzz.fizzBuzzCalculation(58));
    }

    @Test
    public void testContainsNegativeFive() {
        assertEquals("buzz", FizzBuzz.fizzBuzzCalculation(-58));
    }

    @Test
    public void testMultiplesOfThree() {
        assertEquals("fizz", FizzBuzz.fizzBuzzCalculation(6));
    }

    @Test
    public void testNegativeMultiplesOfThree() {
        assertEquals("fizz", FizzBuzz.fizzBuzzCalculation(-6));
    }

    @Test
    public void testContainsThree() {
        assertEquals("fizz", FizzBuzz.fizzBuzzCalculation(13));
    }

    @Test
    public void testContainsNegativeThree() {
        assertEquals("fizz", FizzBuzz.fizzBuzzCalculation(-13));
    }

    @Test
    public void testMultiAndContains() {
        assertEquals("fizz buzz buzz", FizzBuzz.fizzBuzzCalculation(35));
    }

    @Test
    public void testMultiOf3AndContains3() {
        assertEquals("fizz fizz", FizzBuzz.fizzBuzzCalculation(33));
    }

    @Test
    public void testMultiOf5AndContains5() {
        assertEquals("buzz buzz", FizzBuzz.fizzBuzzCalculation(50));
    }

    @Test
    public void testNegativeMultiOf5AndContains5() {
        assertEquals("buzz buzz", FizzBuzz.fizzBuzzCalculation(-50));
    }

    @Test
    public void testNoFizzBuzzFound() {
        assertEquals("1", FizzBuzz.fizzBuzzCalculation(1));
    }

    @Test
    public void testZeroNoFizzBuzzFound() {
        assertEquals("0", FizzBuzz.fizzBuzzCalculation(0));
    }


}
