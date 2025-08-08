package name.lorenzani.andrea.hackerrank.deliveroo.MagicSquare;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class ResultTest extends TestCase {

    public void testCase1() {
        List<List<Integer>> input = List.of(
                List.of(4,9,2),
                List.of(3,5,7),
                List.of(8,1,5)
        );

        assertEquals(1, Result.formingMagicSquare(createArray(input)));

    }

    public void testCase2() {
        List<List<Integer>> input = List.of(
                List.of(4,8,2),
                List.of(4,5,7),
                List.of(6,1,6)
        );

        assertEquals(4, Result.formingMagicSquare(createArray(input)));

    }

    private List<List<Integer>> createArray(List<List<Integer>> input) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<3; i++) {
            res.add(new ArrayList<>());
            res.get(i).addAll(input.get(i));
        }
        return res;
    }

}