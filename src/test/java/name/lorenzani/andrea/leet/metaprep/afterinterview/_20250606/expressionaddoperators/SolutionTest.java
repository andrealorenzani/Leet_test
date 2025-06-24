package name.lorenzani.andrea.leet.metaprep.afterinterview._20250606.expressionaddoperators;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionTest extends TestCase {

    public void testBasic1() {
        Solution s = new Solution();
        equals(List.of("1*2*3","1+2+3"), s.addOperators("123", 6));
    }

    private void equals(List<String> expected, List<String> actual) {
        if(expected==null && actual==null) return;
        if((expected!=null && actual==null)
                ||(expected==null && actual!=null)) fail();

        HashSet<String> expectedSet = new HashSet<String>(expected);
        HashSet<String> actualSet = new HashSet<String>(actual);

        if(!expectedSet.containsAll(actualSet) || !actualSet.containsAll(expectedSet)) {
            fail(String.format("Expected %s but actual si %s", expectedSet, actualSet));
        }
    }

}