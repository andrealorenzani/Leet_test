package name.lorenzani.andrea.hackerrank.sainsburys.Test1;

import junit.framework.TestCase;
import name.lorenzani.andrea.useful_algo.Invert;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class SolutionTest {
    @Test
    public void testInverter() {
        Assert.assertEquals("11,12,13,14,15,16,17,18,19,22,23,24,25,26,27,28", Solution.run(3));
    }

}