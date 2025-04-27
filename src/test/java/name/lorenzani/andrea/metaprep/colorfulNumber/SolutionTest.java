package name.lorenzani.andrea.metaprep.colorfulNumber;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testCases() {
        Assert.assertTrue(Solution.colorfulNumber(3245));
        Assert.assertFalse(Solution.colorfulNumber(326));
    }

}