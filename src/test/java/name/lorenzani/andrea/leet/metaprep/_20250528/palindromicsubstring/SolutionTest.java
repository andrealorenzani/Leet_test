package name.lorenzani.andrea.leet.metaprep._20250528.palindromicsubstring;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testFailing1() {
        Solution s = new Solution();
        assertEquals(6, s.countSubstrings("fdsklf"));
    }

}