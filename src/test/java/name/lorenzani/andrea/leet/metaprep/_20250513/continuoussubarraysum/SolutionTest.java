package name.lorenzani.andrea.leet.metaprep._20250513.continuoussubarraysum;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testComplex() {
        Solution s = new Solution();
        Assert.assertTrue(s.checkSubarraySum(new int[] {23,2,4,6,6}, 7));
    }

    public void testComplex89() {
        Solution s = new Solution();
        Assert.assertFalse(s.checkSubarraySum(new int[] {23,6,9}, 6));
    }

    public void testComplex99() {
        Solution s = new Solution();
        Assert.assertTrue(s.checkSubarraySum(new int[] {23,0,0}, 6));
    }
}