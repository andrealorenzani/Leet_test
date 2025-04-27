package name.lorenzani.andrea.leet.interview150.MinimumSizeSubarraySum;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBasicScenarios() {
        Solution s = new Solution();

        Assert.assertEquals(2, s.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        Assert.assertEquals(1, s.minSubArrayLen(4, new int[]{1,4,4}));
        Assert.assertEquals(0, s.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }

}