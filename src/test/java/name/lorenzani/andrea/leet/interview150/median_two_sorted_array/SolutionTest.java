package name.lorenzani.andrea.leet.interview150.median_two_sorted_array;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBaseScenarioWithEmptyArrays() {
        Solution s = new Solution();
        Assert.assertEquals(1,s.findMedianSortedArrays(new int[]{}, new int[]{1}), 0);
        Assert.assertEquals(1,s.findMedianSortedArrays(new int[]{1}, new int[]{}), 0);
        Assert.assertEquals(2,s.findMedianSortedArrays(new int[]{1,2,3}, new int[]{}), 0);
        Assert.assertEquals(4,s.findMedianSortedArrays(new int[]{}, new int[]{1,3,5,7}), 0);
    }

    public void testBaseScenarioWithSimpleArrays() {
        Solution s = new Solution();
        /*Assert.assertEquals(3,s.findMedianSortedArrays(new int[]{2}, new int[]{4}), 0);
        Assert.assertEquals(4,s.findMedianSortedArrays(new int[]{1,4,6,7}, new int[]{3}), 0);
        Assert.assertEquals(2,s.findMedianSortedArrays(new int[]{1,3}, new int[]{2}), 0);
        Assert.assertEquals(5,s.findMedianSortedArrays(new int[]{1,3,5,7,9}, new int[]{2,4,6,8}), 0);
        Assert.assertEquals(4.5d,s.findMedianSortedArrays(new int[]{0,1,3,5,7,9}, new int[]{2,4,6,8}), 0);*/
        Assert.assertEquals(1.5d,s.findMedianSortedArrays(new int[]{1,2}, new int[]{-1,3}), 0);
    }

}