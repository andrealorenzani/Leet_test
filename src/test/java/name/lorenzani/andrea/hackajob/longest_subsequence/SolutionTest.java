package name.lorenzani.andrea.hackajob.longest_subsequence;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testFromDesc() {
        int res1 = Solution.run(new int[]{0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15});
        //Assert.assertEquals(6, res1);
        Assert.assertEquals(9, res1);
    }

}