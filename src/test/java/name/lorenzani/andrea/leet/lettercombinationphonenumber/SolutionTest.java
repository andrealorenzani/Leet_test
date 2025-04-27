package name.lorenzani.andrea.leet.lettercombinationphonenumber;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class SolutionTest extends TestCase {

    public void testBasicScenarios() {
        Solution s = new Solution();

        Assert.assertEquals(List.of("ad","ae","af","bd","be","bf","cd","ce","cf"), s.letterCombinations("23"));
    }

}