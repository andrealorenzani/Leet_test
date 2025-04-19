package name.lorenzani.andrea.useful_algo;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class InvertTest {

    @Test
    public void testInverter() {
        List<String> example = new LinkedList<>(List.of("ab", "bc", "cd", "de"));
        Invert<String> inverter = new Invert<>();
        Assert.assertEquals(List.of("de", "cd", "bc", "ab"), inverter.invert(example));
    }

    @Test
    public void testStringInverter() {
        Invert<String> inverter = new Invert<>();
        Assert.assertEquals("edcba", inverter.invert("abcde"));
    }

}