package name.lorenzani.andrea.leet.leet_287;

import junit.framework.TestCase;
import name.lorenzani.andrea.leet.leet_287.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testWorking() {
        int value = Solution.findDuplicate(new int[]{1,3,4,2,2});
        Assert.assertEquals(2, value);
    }

}