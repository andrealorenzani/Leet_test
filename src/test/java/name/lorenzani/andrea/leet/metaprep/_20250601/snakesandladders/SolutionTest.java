package name.lorenzani.andrea.leet.metaprep._20250601.snakesandladders;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBasicCase1() {
        assertEquals(4, new Solution().snakesAndLadders(new int[][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}));
    }

    public void testFailing1() {
        assertEquals(1, new Solution().snakesAndLadders(new int[][] {{-1,-1,-1},{-1,9,8},{-1,8,9}}));
    }

    public void testFailing2() {
        assertEquals(4, new Solution().snakesAndLadders(new int[][] {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}));
    }
    public void testFailing3() {
        assertEquals(-1, new Solution().snakesAndLadders(new int[][] {{1,1,-1},{1,1,1},{-1,1,1}}));
    }

}