package name.lorenzani.andrea.hackajob.find_singleton;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    public void testFromDesc() {
        int res1 = Solution.run(new int[] {5,3,2,2,3,5,4,6,9,6,4,12,8,9,12});
        Assert.assertEquals(8, res1);
        int res2 = Solution.run(new int[] {2,2,10,5,4,6,7,5,8,8,6,4,7});
        Assert.assertEquals(10, res2);
        int res3 = Solution.run(new int[] {2015,2000,1092,2042,2016,2015,2000,1994,23,1092,2042,23,1994});
        Assert.assertEquals(2016, res3);
        int res4 = Solution.run(new int[] {53491,62276,82233,66051,97664,27657,45882,46503,27064,64689,70329,62843,84840,53491,62276,82233,66051,97664,27657,45882,46503,27064,64689,70329,62843,84840,1337});
        Assert.assertEquals(1337, res4);
    }
}