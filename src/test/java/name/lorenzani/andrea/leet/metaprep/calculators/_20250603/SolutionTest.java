package name.lorenzani.andrea.leet.metaprep.calculators._20250603;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBasic1() {
        assertEquals(2, new Solution().calculate("1 + 1"));
    }
    public void testBasic2() {
        assertEquals(3, new Solution().calculate("2-1 + 2"));
    }
    public void testBasic3() {
        assertEquals(23, new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
    }

    public void testPersonal1() {
        assertEquals(18, new Solution().calculate("6*(1+2)"));
    }

    public void testPersonal2() {
        assertEquals(36, new Solution().calculate("6*(1+2)*2"));
    }

    public void testPersonal3() {
        assertEquals(36, new Solution().calculate("6*3*2"));
    }

}