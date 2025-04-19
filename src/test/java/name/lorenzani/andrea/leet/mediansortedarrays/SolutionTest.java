package name.lorenzani.andrea.leet.mediansortedarrays;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;
import name.lorenzani.andrea.mediansortedarrays.*;

public class SolutionTest extends TestCase {

    public void testCase1() {
        Solution solution = new Solution();
        int[] array1 = new int[] {1,3};
        int[] array2 = new int[] {2};

        double res = solution.findMedianSortedArrays(array1, array2);
        Assert.assertEquals(2, res, 0d);
    }

    public void testCase2() {
        Solution solution = new Solution();
        int[] array1 = new int[] {1,2};
        int[] array2 = new int[] {3,4};

        double res = solution.findMedianSortedArrays(array1, array2);
        Assert.assertEquals( 2.5d, 0d, 0);
    }

}