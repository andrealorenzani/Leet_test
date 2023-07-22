package name.lorenzani.andrea.leet.leet_2225;

import java.util.*;

public class Solution {
    public static List<List<Integer>> findWinners(int[][] matches) {
        int[] res = new int[100000];
        Arrays.fill(res, -1);
        for (int[] match : matches) {
            res[match[0]] = (res[match[0]]==-1)?0:res[match[0]];
            res[match[1]] = (res[match[1]]==-1)?1:res[match[1]] + 1;
        }
        List<Integer> lostZero = new ArrayList<>(matches.length);
        List<Integer> lostOne = new ArrayList<>(matches.length);
        for(int i=0; i<res.length; i++) {
            if(res[i]==0) lostZero.add(i);
            else if(res[i]==1) lostOne.add(i);
        }
        return List.of(lostZero, lostOne);
    }

    public static List<List<Integer>> findWinnersBrute(int[][] matches) {
        TreeMap<Integer, Integer> res = new TreeMap<Integer, Integer>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            res.putIfAbsent(winner, 0);
            res.computeIfPresent(loser, (key, val) -> val + 1);
            res.putIfAbsent(loser, 1);
        }
        List<Integer> lostZero = new ArrayList<>(matches.length);
        List<Integer> lostOne = new ArrayList<>(matches.length);
        res.forEach((key, value) -> {
            if(value == 0) lostZero.add(key);
            else if(value == 1) lostOne.add(key);
        });
        return List.of(lostZero, lostOne);
    }
}
