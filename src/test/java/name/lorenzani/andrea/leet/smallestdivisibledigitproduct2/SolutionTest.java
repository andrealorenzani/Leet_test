package name.lorenzani.andrea.leet.smallestdivisibledigitproduct2;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testBasicScenarios() {
        Solution s = new Solution();

        Assert.assertEquals("-1", s.smallestNumber("1111", 26));
        Assert.assertEquals("12355", s.smallestNumber("12355", 50));
        Assert.assertEquals("1488", s.smallestNumber("1234", 256));
        Assert.assertEquals("488", s.smallestNumber("123", 256));
        Assert.assertEquals("13488", s.smallestNumber("12499", 256));
    }

    public void testAdvancedScenarios() {
        Solution s = new Solution();

        Assert.assertEquals("255555579", s.smallestNumber("12", 1968750));
        Assert.assertEquals("2555678888888", s.smallestNumber("12", 22020096000l));
        Assert.assertEquals("21", s.smallestNumber("19", 2));
        Assert.assertEquals("33", s.smallestNumber("30", 9));

    }

}