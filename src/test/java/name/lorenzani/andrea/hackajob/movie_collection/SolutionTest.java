package name.lorenzani.andrea.hackajob.movie_collection;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionTest extends TestCase {

    public void testFromDesc() {
        String res1 = Solution.run(3, 3, new int[]{3,1,1});
        Assert.assertEquals("2,1,0", res1);
        String res2 = Solution.run(5, 3, new int[]{4,4,5});
        Assert.assertEquals("3,0,4", res2);
    }

}