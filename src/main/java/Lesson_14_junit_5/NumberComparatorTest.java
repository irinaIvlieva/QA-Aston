package Lesson_14_junit_5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberComparatorTest {
    @Test
    public void testCompare() {
        NumberComparator comparator = new NumberComparator();
        assertEquals("2 is greater than 1", comparator.compare(2, 1));
        assertEquals("1 is less than 2", comparator.compare(1, 2));
        assertEquals("1 is equal to 1", comparator.compare(1, 1));
    }
}
