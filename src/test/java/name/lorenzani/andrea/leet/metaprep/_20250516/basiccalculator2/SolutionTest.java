package name.lorenzani.andrea.leet.metaprep._20250516.basiccalculator2;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBasicCases() {
        Solution s = new Solution();

        assertEquals(7, s.calculate("3+2*2"));
        assertEquals(1, s.calculate("3/2"));
        assertEquals(5, s.calculate("3+5 / 2"));

    }

    public void testFailed() {
        Solution s = new Solution();
        assertEquals(0, s.calculate("0/1"));
    }

    public void testFailed2() {
        Solution s = new Solution();
        assertEquals(6, s.calculate("1+2*5/3+6/4*2"));
    }

}