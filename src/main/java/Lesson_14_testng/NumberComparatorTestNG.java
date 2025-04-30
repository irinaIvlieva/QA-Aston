package Lesson_14_testng;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class NumberComparatorTestNG {
    @Test
    public void testCompare() {
        NumberComparator comparator = new NumberComparator();
        assertEquals(comparator.compare(2, 1), "2 is greater than 1");
        assertEquals(comparator.compare(1, 1), "1 is equal to 1");
    }
}
