package name.lorenzani.andrea.leet.interview150.rotatearray;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBasic() {
        Solution s = new Solution();

        assertEquals(new int[]{5,6,7,1,2,3,4}, new int[]{1,2,3,4,5,6,7}, 3);
        assertEquals(new int[]{3,99,-1,-100}, new int[]{-1,-100,3,99}, 2);
        assertEquals(new int[]{-1}, new int[]{-1}, 2);
    }

    private void assertEquals(int[] expected, int[] input, int k) {
        Solution s = new Solution();
        s.rotate(input, k);
        for(int i=0; i< expected.length;i++){
            Assert.assertEquals(expected[i], input[i]);
        }
    }

}