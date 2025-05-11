package name.lorenzani.andrea.leet.metaprep._20250508.container;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBaseCases() {
        Solution s = new Solution();

        Assert.assertEquals(49, s.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        Assert.assertEquals(1, s.maxArea(new int[]{1,1}));
    }

}