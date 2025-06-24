package name.lorenzani.andrea.leet.metaprep._20250528.validpalindrome3;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testBasic1() {
        Solution s = new Solution();

        assertTrue(s.isValidPalindrome("abcdeca", 2));
    }

    public void testFailing1() {
        Solution s = new Solution();

        assertTrue(s.isValidPalindrome("fcgihcgeadfehgiabegbiahbeadbiafgcfchbcacedbificicihibaeehbffeidiaiighceegbfdggggcfaiibefbgeegbcgeadcfdfegfghebcfceiabiagehhibiheddbcgdebdcfegaiahibcfhheggbheebfdahgcfcahafecfehgcgdabbghddeadecidicchfgicbdbecibddfcgbiadiffcifiggigdeedbiiihfgehhdegcaffaggiidiifgfigfiaiicadceefbhicfhbcachacaeiefdcchegfbifhaeafdehicfgbecahidgdagigbhiffhcccdhfdbd", 216));
    }

    public void testFailing2() {
        Solution s = new Solution();

        assertTrue(s.isValidPalindrome("aaabaabaa", 1));
    }

    public void testFailing3() {
        Solution s = new Solution();

        assertFalse(s.isValidPalindrome("abcdefghijk", 6));
    }
    public void testFailing4() {
        Solution s = new Solution();

        assertTrue(s.isValidPalindrome("baacacaa", 1));
    }

    public void testFailing5() {
        Solution s = new Solution();

        assertFalse(s.isValidPalindrome("baaabababbaabbbaabaabaabbbabbbaabbbbbbbbbbaaaaabaabababbbababbbbabbabbbababaaababaabababbaaabaaaaabbaabbbbabaaaaaaabbaabbaaaaabaaaaaaaabaaabaababababa", 37));
    }

}