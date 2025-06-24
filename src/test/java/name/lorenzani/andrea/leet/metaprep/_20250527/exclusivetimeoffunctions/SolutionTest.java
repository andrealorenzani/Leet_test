package name.lorenzani.andrea.leet.metaprep._20250527.exclusivetimeoffunctions;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;

public class SolutionTest extends TestCase {

    public void testBasicScenario() {
        Solution s = new Solution();

        Assert.assertArrayEquals(new int[] {3,4 }, s.exclusiveTime(2, List.of("0:start:0","1:start:2","1:end:5","0:end:6")));
    }

    public void testBasicScenario2() {
        Solution s = new Solution();

        Assert.assertArrayEquals(new int[] {8},
                s.exclusiveTime(1, List.of("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7")));
    }

    public void testBasicScenario3() {
        Solution s = new Solution();

        Assert.assertArrayEquals(new int[] {7,1},
                s.exclusiveTime(2, List.of("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7")));
    }

    public void testFailing1() {
        Solution s = new Solution();

        Assert.assertArrayEquals(new int[] {20,14,35,7,6,9,10,14},
                s.exclusiveTime(8, List.of("0:start:0","1:start:5","2:start:6","3:start:9","4:start:11","5:start:12","6:start:14","7:start:15","1:start:24","1:end:29","7:end:34","6:end:37","5:end:39","4:end:40","3:end:45","0:start:49","0:end:54","5:start:55","5:end:59","4:start:63","4:end:66","2:start:69","2:end:70","2:start:74","6:start:78","0:start:79","0:end:80","6:end:85","1:start:89","1:end:93","2:end:96","2:end:100","1:end:102","2:start:105","2:end:109","0:end:114")));
    }

}