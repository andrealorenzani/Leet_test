package name.lorenzani.andrea.leet.leet_2225;

import junit.framework.TestCase;
import name.lorenzani.andrea.leet.leet_2225.Solution;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class SolutionTest extends TestCase {

    public void testMain() {
        int[][] matches = new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}};
        List<List<Integer>> res = Solution.findWinners(matches);
        Assert.assertEquals(Arrays.asList(1,2,10), res.get(0));
        Assert.assertEquals(Arrays.asList(4,5,7,8), res.get(1));
    }

}