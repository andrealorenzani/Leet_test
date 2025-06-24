package name.lorenzani.andrea.leet.metaprep._20250520.makingalargeisland;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBaseCases() {
        Solution s = new Solution();

        assertEquals(4, s.largestIsland(new int[][]{{1,1}, {1,0}}));
        assertEquals(3, s.largestIsland(new int[][]{{1,0}, {0,1}}));
        assertEquals(4, s.largestIsland(new int[][]{{1,1}, {1,1}}));
    }

    public void testFailingCases() {
        Solution s = new Solution();

        //assertEquals(2, s.largestIsland(new int[][]{{0,0}, {0,1}}));
        assertEquals(1, s.largestIsland(new int[][]{{1}}));
        //assertEquals(2, s.largestIsland(new int[][]{{0,0}, {1,0}}));
    }

    public void testFailingComplexCases() {
        Solution s = new Solution();

        assertEquals(18, s.largestIsland(new int[][]{{0,0,0,0,0,0,0},{0,1,1,1,1,0,0},{0,1,0,0,1,0,0},{1,0,1,0,1,0,0},{0,1,0,0,1,0,0},{0,1,0,0,1,0,0},{0,1,1,1,1,0,0}}));
    }

}