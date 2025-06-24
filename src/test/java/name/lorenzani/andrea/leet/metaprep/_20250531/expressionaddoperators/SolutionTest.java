package name.lorenzani.andrea.leet.metaprep._20250531.expressionaddoperators;

import junit.framework.TestCase;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionTest extends TestCase {

    public void testBasic1() {
        Solution sol = new Solution();

        assertArrayEq(List.of("1*2*3","1+2+3"), sol.addOperators("123", 6));
    }

    public void testBasic2() {
        Solution sol = new Solution();

        assertArrayEq(List.of("2*3+2", "2+3*2"), sol.addOperators("232", 8));
    }

    public void testBasic3() {
        Solution sol = new Solution();

        assertArrayEq(List.of(), sol.addOperators("3456237490", 9191));
    }

    public void assertArrayEq(List<String> expected, List<String> actual) {
        if(expected == null && actual == null) {
            assertTrue(true);
            return;
        }
        if((expected != null && actual == null) || (expected == null && actual != null)) fail();
        HashSet<String> expSet = new HashSet<>(expected);
        HashSet<String> actSet = new HashSet<>(actual);
        assertTrue(String.format("Expected %s  -- Actual %s", expected, actual), expSet.containsAll(actual));
        assertTrue(String.format("Expected %s  -- Actual %s", expected, actual), actSet.containsAll(expected));
    }

}