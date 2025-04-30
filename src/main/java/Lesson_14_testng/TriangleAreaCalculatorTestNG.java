package Lesson_14_testng;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class TriangleAreaCalculatorTestNG {
    @Test
    public void testCalculateArea() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        assertEquals(calculator.calculateArea(5, 4), 10.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInvalidInput() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        calculator.calculateArea(0, 4);
    }
}
