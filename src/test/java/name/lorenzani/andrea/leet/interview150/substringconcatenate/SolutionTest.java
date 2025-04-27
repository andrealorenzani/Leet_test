package name.lorenzani.andrea.leet.interview150.substringconcatenate;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class SolutionTest extends TestCase {

    public void testBasicScenarios() {
        Solution s = new Solution();

        Assert.assertEquals(Arrays.asList(0, 9), s.findSubstring("barfoothefoobarman", new String[]{"foo","bar"}));
        Assert.assertEquals(new ArrayList<>(), s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        Assert.assertEquals(Arrays.asList(6, 9, 12), s.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"}));
    }

    public void testAdvancedScenarios() {
        Solution s = new Solution();

        Assert.assertEquals(Arrays.asList(8), s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

}