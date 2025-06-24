package name.lorenzani.andrea.leet.metaprep._20250528.slidingwindowmedian;

import junit.framework.AssertionFailedError;
import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBasics() {
        Solution s = new Solution();

        assertArrayEquals(new double[]{1d, -1d, -1d, 3d, 5d, 6d},
                s.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }

    public void testFailing1() {
        Solution s = new Solution();

        assertArrayEquals(new double[]{2.5d},
                s.medianSlidingWindow(new int[]{1,4,2,3}, 4));
    }
    public void testFailing2() {
        Solution s = new Solution();

        assertArrayEquals(new double[]{8d, 8d, 8d,3d,5d,3d,5d,4d},
                s.medianSlidingWindow(new int[]{7,8,8,3,8,1,5,3,5,4}, 3));
    }

    public void assertArrayEquals(double[] expected, double[] actual) {
        if(expected==null && actual == null) return;
        assertEquals("The size of arrays differs", expected.length, actual.length);
        for(int i=0; i< expected.length; i++) {
            assertEquals(String.format("Value in position %d differs!!!", i), expected[i], actual[i], 0.00001d);
        }
    }

}