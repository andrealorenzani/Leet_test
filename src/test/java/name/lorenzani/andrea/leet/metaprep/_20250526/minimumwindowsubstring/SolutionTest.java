package name.lorenzani.andrea.leet.metaprep._20250526.minimumwindowsubstring;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBasic1() {
        Solution s = new Solution();
        assertEquals("BANC", s.minWindow("ADOBECODEBANC", "ABC"));
    }

    public void testBasic2() {
        Solution s = new Solution();
        assertEquals("a", s.minWindow("a", "a"));
    }

    public void testBasic3() {
        Solution s = new Solution();
        assertEquals("", s.minWindow("a", "aa"));
    }

    public void testFail1() {
        Solution s = new Solution();
        assertEquals("ab", s.minWindow("bdab", "ab"));
    }

    public void testFail2() {
        Solution s = new Solution();
        assertEquals("aec", s.minWindow("cabefgecdaecf", "cae"));
    }

    public void testFail3() {
        Solution s = new Solution();
        assertEquals("b", s.minWindow("ab", "b"));
    }

}