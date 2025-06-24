package name.lorenzani.andrea.leet.metaprep._20250526.maxconsecutiveones3;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBasic1() {
        Solution sol = new Solution();

        assertEquals(6, sol.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0}, 2));
    }

    public void testBasic2() {
        Solution sol = new Solution();

        assertEquals(10, sol.longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
    }

}