package name.lorenzani.andrea.hackerrank.sainsburys.Test1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static String run(int input) {

        List<List<Integer>> allResult = generateNextLevel(input);

        String result = allResult.stream().flatMap(Collection::stream)
                .map(String::valueOf).collect(Collectors.joining(","));
        return result;
    }

    private static List<List<Integer>> generateNextLevel(int digits) {
        if(digits<1) throw new RuntimeException("Digits should be 1");
        if(digits==1) return List.of(List.of(1),List.of(2),List.of(3),List.of(4),
                List.of(5),List.of(6),List.of(7),List.of(8),List.of(9));
        List<List<Integer>> result = new ArrayList<>(9);
        List<List<Integer>> nextLevel = generateNextLevel(digits-1);
        for(int i=1; i<=9; i++) {
            List<Integer> tmp = new ArrayList<>();
            int firstDigit = (int)(i * Math.pow(10, digits-1));
            for(int j=i; j<10; j++) {
                List<Integer> next = nextLevel.get(j-1);
                tmp.addAll(next.stream().map(value -> firstDigit+value).collect(Collectors.toList()));
            }
            result.add(tmp);
        }
        return result;
    }
}
