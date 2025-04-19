package name.lorenzani.andrea.leet.goodtriplet;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testExamples(){
        int[] values = new int[] {4,9,9,8,9,5,3,7};
        Solution s = new Solution();
        s.countGoodTriplets(values, 1,3,0);
    }

}