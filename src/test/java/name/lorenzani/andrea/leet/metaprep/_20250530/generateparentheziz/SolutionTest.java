package name.lorenzani.andrea.leet.metaprep._20250530.generateparentheziz;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionTest extends TestCase {

    public void testCase2() {
        Solution s = new Solution();
        assertArrayEquals(List.of("(())", "()()"), s.generateParenthesis(2));
    }

    public void testCase3() {
        Solution s = new Solution();
        assertArrayEquals(List.of("((()))", "(()())", "(())()", "()(())", "()()()"), s.generateParenthesis(3));

    }

    public void testCase4() {
        Solution s = new Solution();
        assertArrayEquals(List.of("(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"), s.generateParenthesis(4));
    }

    public void testCase6() {
        Solution s = new Solution();
        List<String> expected = List.of("(((((())))))","((((()()))))","((((())())))","((((()))()))","((((())))())","((((()))))()","(((()(()))))","(((()()())))","(((()())()))","(((()()))())","(((()())))()","(((())(())))","(((())()()))","(((())())())","(((())()))()","(((()))(()))","(((()))()())","(((()))())()","(((())))(())","(((())))()()","((()((()))))","((()(()())))","((()(())()))","((()(()))())","((()(())))()","((()()(())))","((()()()()))","((()()())())","((()()()))()","((()())(()))","((()())()())","((()())())()","((()()))(())","((()()))()()","((())((())))","((())(()()))","((())(())())","((())(()))()","((())()(()))","((())()()())","((())()())()","((())())(())","((())())()()","((()))((()))","((()))(()())","((()))(())()","((()))()(())","((()))()()()","(()(((()))))","(()((()())))","(()((())()))","(()((()))())","(()((())))()","(()(()(())))","(()(()()()))","(()(()())())","(()(()()))()","(()(())(()))","(()(())()())","(()(())())()","(()(()))(())","(()(()))()()","(()()((())))","(()()(()()))","(()()(())())","(()()(()))()","(()()()(()))","(()()()()())","(()()()())()","(()()())(())","(()()())()()","(()())((()))","(()())(()())","(()())(())()","(()())()(())","(()())()()()","(())(((())))","(())((()()))","(())((())())","(())((()))()","(())(()(()))","(())(()()())","(())(()())()","(())(())(())","(())(())()()","(())()((()))","(())()(()())","(())()(())()","(())()()(())","(())()()()()","()((((()))))","()(((()())))","()(((())()))","()(((()))())","()(((())))()","()((()(())))","()((()()()))","()((()())())","()((()()))()","()((())(()))","()((())()())","()((())())()","()((()))(())","()((()))()()","()(()((())))","()(()(()()))","()(()(())())","()(()(()))()","()(()()(()))","()(()()()())","()(()()())()","()(()())(())","()(()())()()","()(())((()))","()(())(()())","()(())(())()","()(())()(())","()(())()()()","()()(((())))","()()((()()))","()()((())())","()()((()))()","()()(()(()))","()()(()()())","()()(()())()","()()(())(())","()()(())()()","()()()((()))","()()()(()())","()()()(())()","()()()()(())","()()()()()()");
        assertArrayEquals(expected, s.generateParenthesis(6));
    }

    private void assertArrayEquals(List<String> expected, List<String> actual) {
        if(expected == null && actual == null) {
            return;
        }
        else if((expected != null && actual == null) || (expected == null && actual != null)) {
            throw new AssertionError("Different array size");
        }

        Set<String> expset = new HashSet<>(expected);
        Set<String> ogExpset = new HashSet<>(expected);

        if(expected.size() != actual.size()) {
            while(!actual.isEmpty() && !expset.isEmpty()) {
                actual.forEach(expset::remove);
                ogExpset.forEach(actual::remove);
            }
            System.err.println("The intersection is ACTUAL: "+actual.toString()+"   ---   EXPECTED: "+expset.toString());
            assertFalse(expected.size() != actual.size());
        }

        for(int i=0; i< expected.size(); i++) {
            assertTrue("Actual "+actual.toString()+" is not the same as expected "+expected.toString(), expset.containsAll(actual));
        }
    }
}