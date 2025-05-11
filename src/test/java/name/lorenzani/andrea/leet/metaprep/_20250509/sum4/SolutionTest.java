package name.lorenzani.andrea.leet.metaprep._20250509.sum4;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class SolutionTest extends TestCase {

    public void testZeros() {
        Assert.assertArrayEquals(new int[][]{{0,0,0,0}},
                new Solution().fourSum(new int[]{0,0,0,0}, 0).stream()
                        .map(List::toArray).toArray());
    }
    public void testLimit() {
        Assert.assertArrayEquals(new int[][]{},
                new Solution().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296).stream()
                        .map(List::toArray).toArray());
    }
}