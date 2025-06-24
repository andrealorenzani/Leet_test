package name.lorenzani.andrea.leet.metaprep._20250518.diagonaltraverse;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBasicScenarios() {
        Solution s = new Solution();

        Assert.assertArrayEquals(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}, s.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        Assert.assertArrayEquals(new int[]{1,2,3,4}, s.findDiagonalOrder(new int[][]{{1,2,},{3,4}}));
    }

}