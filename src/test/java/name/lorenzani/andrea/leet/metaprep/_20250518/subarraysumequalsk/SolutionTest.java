package name.lorenzani.andrea.leet.metaprep._20250518.subarraysumequalsk;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testFailing(){
        Solution s = new Solution();

        assertEquals(1, s.subarraySum(new int[]{-1, -1, 1}, 0));
        assertEquals(3, s.subarraySum(new int[]{1, -1, 0}, 0));
    }

}