package name.lorenzani.andrea.metaprep.snakesLadders;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class ResultTest extends TestCase {

    public void testQuick() {
        List<List<Integer>> ladders = List.of(List.of(32,62), List.of(42, 68), List.of(12, 98));
        List<List<Integer>> snakes = List.of(List.of(95, 13), List.of(97, 25), List.of(93, 37), List.of(79, 27), List.of(75, 19), List.of(49, 47), List.of(67, 17));

        Assert.assertEquals(3, Result.quickestWayUp(ladders, snakes));
    }

    public void testQuick2() {
        List<List<Integer>> ladders = List.of(List.of(8, 52), List.of(6, 80), List.of(26, 42), List.of(2, 72));
        List<List<Integer>> snakes = List.of(List.of(51, 19), List.of(39, 11), List.of(37, 29), List.of(81, 3), List.of(59, 5), List.of(79, 23), List.of(53, 7), List.of(43, 33), List.of(77, 21));

        Assert.assertEquals(5, Result.quickestWayUp(ladders, snakes));
    }


    public void testQuick3() {
        List<List<Integer>> ladders = List.of(List.of(5, 66), List.of(9, 88));
        List<List<Integer>> snakes = List.of(List.of(67, 8));

        Assert.assertEquals(4, Result.quickestWayUp(ladders, snakes));
    }

    public void testQuick4() {
        List<List<Integer>> ladders = List.of(List.of(3, 90));
        List<List<Integer>> snakes = List.of(List.of(99, 10), List.of(97, 20), List.of(98, 30), List.of(96, 40), List.of(95, 50), List.of(94, 60), List.of(93, 70));

        Assert.assertEquals(-1, Result.quickestWayUp(ladders, snakes));
    }
    public void testQuick5() {
        List<List<Integer>> ladders = List.of(List.of(3, 54), List.of(37, 100));
        List<List<Integer>> snakes = List.of(List.of(56, 33));

        Assert.assertEquals(3, Result.quickestWayUp(ladders, snakes));
    }

    public void testQuick6() {
        List<List<Integer>> ladders = List.of(List.of(3, 57), List.of(8, 100));
        List<List<Integer>> snakes = List.of(List.of(88, 44));

        Assert.assertEquals(2, Result.quickestWayUp(ladders, snakes));
    }
    public void testQuick7() {
        List<List<Integer>> ladders = List.of(List.of(7, 98));
        List<List<Integer>> snakes = List.of(List.of(99, 1));

        Assert.assertEquals(2, Result.quickestWayUp(ladders, snakes));
    }

}