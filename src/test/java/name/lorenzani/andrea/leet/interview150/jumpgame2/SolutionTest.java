package name.lorenzani.andrea.leet.interview150.jumpgame2;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBasic() {
        Solution s = new Solution();
        Assert.assertEquals(2, s.jump(new int[]{2,3,1,1,4}));
        Assert.assertEquals(2, s.jump(new int[]{2,3,0,1,4}));
    }

}