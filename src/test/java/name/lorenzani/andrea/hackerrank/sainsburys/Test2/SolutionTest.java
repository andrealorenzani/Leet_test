package name.lorenzani.andrea.hackerrank.sainsburys.Test2;

import junit.framework.TestCase;
import name.lorenzani.andrea.hackerrank.sainsburys.Test2.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void testInverter() {
        Assert.assertEquals(3, Solution.run(5));

        Assert.assertEquals(356, Solution.run(9999));
    }

    /*
    * f(1) = 1
    * f(2) = 1 + f(2 - f(f(1)) = 2
    * f(3) = 1 + f(3 - f(f(2)) = 2
    * f(4) = 1 + f(4 -
    * */
}