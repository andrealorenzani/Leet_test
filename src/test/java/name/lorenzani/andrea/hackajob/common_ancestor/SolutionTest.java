package name.lorenzani.andrea.hackajob.common_ancestor;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testFromDesc() {
        int res1 = Solution.run(13, 15);
        Assert.assertEquals(3, res1);
        int res2 = Solution.run(11, 13);
        Assert.assertEquals(1, res2);
        int res3 = Solution.run(10,11);
        Assert.assertEquals(5, res3);
        int res4 = Solution.run(25, 100);
        Assert.assertEquals(12, res4);
    }
}
