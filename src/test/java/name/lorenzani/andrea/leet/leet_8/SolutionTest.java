package name.lorenzani.andrea.leet.leet_8;

import junit.framework.TestCase;
import name.lorenzani.andrea.leet.leet_8.Solution;
import org.junit.Assert;

public class SolutionTest extends TestCase {
    public void testCaseWrong(){
        String test = "   -42";
        Assert.assertEquals(-42, Solution.myAtoi(test));
    }
    public void testCaseWrong2(){
        String test = "123-";
        //Assert.assertEquals(-42, Solution.myAtoi(test));
        Assert.assertEquals(123, Solution.myAtoi(test));
    }
    public void testMax() {
        String test = "-6147483648";
        int expected = -2147483648;
        Assert.assertEquals(expected, Solution.myAtoi(test));
    }
    public void testBoh() {
        String test = "-91283472332";
        int expected = -2147483648;
        Assert.assertEquals(expected, Solution.myAtoi(test));
    }
}