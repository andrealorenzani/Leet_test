package name.lorenzani.andrea.leet.interview150.trappingrainwater_42;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testTrap() {
        int[] values = new int[] {5,4,1,2};
        int expected = 1;

        assertEquals(expected, new Solution().trap(values));
    }
}