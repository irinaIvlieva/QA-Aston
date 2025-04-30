package Lesson_14_junit_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {
    @Test
    public void testCalculateFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();
        assertEquals(1, calculator.calculateFactorial(0));
        assertEquals(1, calculator.calculateFactorial(1));
        assertEquals(120, calculator.calculateFactorial(5));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateFactorial(-1));
    }
}
