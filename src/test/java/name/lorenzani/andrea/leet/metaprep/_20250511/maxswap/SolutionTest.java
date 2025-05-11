package name.lorenzani.andrea.leet.metaprep._20250511.maxswap;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBase() {
        Solution sol = new Solution();

        Assert.assertEquals(9973, sol.maximumSwap(9973));
        Assert.assertEquals(7236, sol.maximumSwap(2736));
    }

    public void testBroken() {
        Solution sol = new Solution();

        Assert.assertEquals(98863, sol.maximumSwap(98368));
    }

}