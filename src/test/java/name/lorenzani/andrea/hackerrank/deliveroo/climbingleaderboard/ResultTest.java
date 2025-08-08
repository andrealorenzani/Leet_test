package name.lorenzani.andrea.hackerrank.deliveroo.climbingleaderboard;

import junit.framework.TestCase;

import java.util.List;

public class ResultTest extends TestCase {

    public void testCase1() {
        assertEquals(List.of(6,4,2,1),
                Result.climbingLeaderboard(List.of(100, 100, 50, 40, 40, 20, 10),
                        List.of(5,25,50, 120)));
    }

}