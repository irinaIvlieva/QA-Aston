package Lesson_14_junit_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaCalculatorTest {
    @Test
    public void testCalculateArea() {
        TriangleAreaCalculator calculator = new TriangleAreaCalculator();
        assertEquals(10.0, calculator.calculateArea(5, 4));
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateArea(0, 4));
    }
}