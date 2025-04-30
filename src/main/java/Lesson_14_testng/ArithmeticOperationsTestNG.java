package Lesson_14_testng;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ArithmeticOperationsTestNG {
    @Test
    public void testOperations() {
        ArithmeticOperations operations = new ArithmeticOperations();
        assertEquals(operations.add(2, 3), 5);
        assertEquals(operations.divide(2, 3), 0.666, 0.001);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        ArithmeticOperations operations = new ArithmeticOperations();
        operations.divide(2, 0);
    }
}
