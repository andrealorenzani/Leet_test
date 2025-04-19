package name.lorenzani.andrea.leet.interview150.TwoSum2;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Arrays;

public class SolutionTest extends TestCase {

    public void testBinarySearch() {
        Solution s = new Solution();

        Assert.assertEquals(0, s.binarySearch(new int[]{1,2,3,4,5}, 1, 0, 5));
        Assert.assertEquals(2, s.binarySearch(new int[]{1,8,9,14,15}, 9, 0, 5));
        Assert.assertEquals(-1, s.binarySearch(new int[]{1,8,9,14,15}, 7, 0, 5));
        Assert.assertEquals(4, s.binarySearch(new int[]{1,8,9,14,15}, 15, 0, 5));
        Assert.assertEquals(-1, s.binarySearch(new int[]{1,8,9,14,15}, 16, 0, 5));
        Assert.assertEquals(1, s.binarySearch(new int[]{2,7,11,15}, 7, 0, 5));
    }

    public void testSolution() {
        Solution s = new Solution();

        assertSolution(new int[]{1,2}, s.twoSum(new int[]{2,7,11,15}, 9));
        assertSolution(new int[]{24,32}, s.twoSum(new int[]{12,13,23,28,43,44,59,60,61,68,70,86,88,92,124,125,136,168,173,173,180,199,212,221,227,230,277,282,306,314,316,321,325,328,336,337,363,365,368,370,370,371,375,384,387,394,400,404,414,422,422,427,430,435,457,493,506,527,531,538,541,546,568,583,585,587,650,652,677,691,730,737,740,751,755,764,778,783,785,789,794,803,809,815,847,858,863,863,874,887,896,916,920,926,927,930,933,957,981,997}, 542));
    }

    public void assertSolution(int[] expected, int[] curr){
        if(expected[0]!=curr[0] || expected[1]!=curr[1]){
            System.out.println(
                    String.format("Expected [%d, %d] - Actual [%d, %d]", expected[0], expected[1], curr[0], curr[1]));
            Assert.fail();
        }
    }

}