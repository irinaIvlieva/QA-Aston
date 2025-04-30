package Lesson_14_testng;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalculatorTestNG {
    @Test
    public void testCalculateFactorial() {
        FactorialCalculator calculator = new FactorialCalculator();
        assertEquals(calculator.calculateFactorial(0), 1);
        assertEquals(calculator.calculateFactorial(5), 120);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeInput() {
        FactorialCalculator calculator = new FactorialCalculator();
        calculator.calculateFactorial(-1);
    }
}
