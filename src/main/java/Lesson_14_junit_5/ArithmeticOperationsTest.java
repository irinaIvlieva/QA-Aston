package Lesson_14_junit_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {
    @Test
    public void testOperations() {
        ArithmeticOperations operations = new ArithmeticOperations();
        assertEquals(5, operations.add(2, 3));
        assertEquals(-1, operations.subtract(2, 3));
        assertEquals(6, operations.multiply(2, 3));
        assertEquals(0.666, operations.divide(2, 3), 0.001);
        assertThrows(ArithmeticException.class, () -> operations.divide(2, 0));
    }
}