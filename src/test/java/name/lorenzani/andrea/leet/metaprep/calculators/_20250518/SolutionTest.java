package name.lorenzani.andrea.leet.metaprep.calculators._20250518;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBasics() {
        Solution s = new Solution();
        assertEquals(5, s.calculate("3+2"));
        assertEquals(1, s.calculate("3-2"));
        assertEquals(6, s.calculate("2*3"));
        assertEquals(3, s.calculate("6/2"));
        assertEquals(9, s.calculate("99/11"));
        assertEquals(0, s.calculate("3+4-1-2*3"));
    }

    public void testParenthesis() {
        Solution s = new Solution();
        assertEquals(8, s.calculate("3+2+(9/3)"));
        assertEquals(0, s.calculate("3-1*(2+1)"));
        assertEquals(36, s.calculate("2*3(4+2)"));
    }

}