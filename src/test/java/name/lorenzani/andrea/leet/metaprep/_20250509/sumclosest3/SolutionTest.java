package name.lorenzani.andrea.leet.metaprep._20250509.sumclosest3;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBasic() {
        Assert.assertEquals(2, new Solution().threeSumClosest(new int[]{-1,2,1,-4}, 1));
        Assert.assertEquals(3, new Solution().threeSumClosest(new int[]{0, 1,2}, 0));
        Assert.assertEquals(15, new Solution().threeSumClosest(new int[]{2,3,8,9,10}, 16));
    }

}