package name.lorenzani.andrea.leet.metaprep._20250506.reverseinteger;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testCase() {
        Solution s = new Solution();
        Assert.assertEquals(-321, s.reverse(-123));
        Assert.assertEquals(-2143443412, s.reverse(-2143443412));
        Assert.assertEquals(0, s.reverse(-2147483622));
    }

    public void testFailure() {
        Solution s = new Solution();
        Assert.assertEquals(0, s.reverse(1534236469));
    }

}