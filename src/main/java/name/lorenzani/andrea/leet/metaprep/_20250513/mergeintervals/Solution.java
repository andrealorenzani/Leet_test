package name.lorenzani.andrea.leet.metaprep._20250513.mergeintervals;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public int[][] mergeWorkBest(int[][] intervals) {
        PriorityQueue<int[]> ordered = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        ordered.addAll(Arrays.asList(intervals));
        int[] iter=ordered.poll();
        ArrayList<int[]> resList = new ArrayList<>();
        while(iter!=null && ordered.size()>=1){
            if(iter[1]>=ordered.peek()[0]){
                int[] tbm = ordered.poll();
                iter[1] = Math.max(iter[1], tbm[1]);
            }
            else {
                resList.add(iter);
                iter = ordered.poll();
            }
        }
        if(iter!=null) resList.add(iter);
        int[][] res = new int[resList.size()][2];
        resList.toArray(res);
        return res;
    }

    public int[][] merge(int[][] intervals) {
        TreeMap<Integer, Integer> ordered = new TreeMap<>();
        for(int i=0; i< intervals.length; i++) {
            int[] newVal = intervals[i];
            Map.Entry<Integer, Integer> candidate = ordered.ceilingEntry(newVal[0]);
            while(candidate!=null) {
                if(mergeable(candidate.getValue(), candidate.getKey(), newVal[0], newVal[1])) {
                    newVal = new int[]{Math.min(newVal[0], candidate.getValue()), Math.max(newVal[1], candidate.getKey())};
                    ordered.remove(candidate.getKey());
                    candidate = ordered.ceilingEntry(intervals[i][0]);
                }
                else candidate=null;
            }
            ordered.put(newVal[1], newVal[0]);
        }
        int[][] res = new int[ordered.size()][2];
        ordered.entrySet().stream()
                .map(x -> new int[]{x.getValue(), x.getKey()})
                .collect(Collectors.toList()).toArray(res);
        return res;
    }

    boolean mergeable(int startA, int endA, int startB, int endB) {
        if(startA>startB) return mergeable(startB, endB, startA, endA);
        return startB <= endA;
    }

}
