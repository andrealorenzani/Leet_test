package name.lorenzani.andrea.leet.metaprep._20250520.groupshiftedstrings;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class SolutionTest extends TestCase {

    public void testBase() {
        Solution s = new Solution();

        Assert.assertEquals(List.of(List.of("acef"), List.of("a", "z"), List.of("abc", "bcd", "xyz"), List.of("az", "ba")),
                s.groupStrings(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"}));
    }

}