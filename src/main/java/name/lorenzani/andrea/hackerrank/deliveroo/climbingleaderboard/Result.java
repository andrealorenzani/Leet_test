package name.lorenzani.andrea.hackerrank.deliveroo.climbingleaderboard;

import java.util.*;

class Result {

    public static List<Integer> climbingLeaderboardTree(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>(player.size());
        HashSet<Integer> test = new HashSet<>();
        final TreeMap<Integer, Integer> ranktree = new TreeMap<>();
        for(int val: ranked) {
            ranktree.putIfAbsent(val, 0);
        }
        for(int pl: player) {
            ranktree.putIfAbsent(pl, 0);
            int pos = ranktree.tailMap(pl).size();
            result.add(pos);
        }
        return result;
    }

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        List<Integer> result = new ArrayList<>(player.size());
        ArrayList<Integer> rankList = new ArrayList<>();
        int prev = -1;
        for(int val:ranked) {
            if(prev!=val) {
                prev = val;
                rankList.add(val);
            }
        }
        int rankPos = rankList.size()-1;
        int plPos = 0;
        for(;plPos < player.size(); plPos++) {
            for(;rankPos>=0; rankPos--){
                if(rankList.get(rankPos)>=player.get(plPos)) {
                    result.add(rankPos+1+((rankList.get(rankPos)==player.get(plPos))?0:1));
                    break;
                }
                else if(rankPos==0) {
                    result.add(1);
                }
            }
        }
        return result;
    }

}

