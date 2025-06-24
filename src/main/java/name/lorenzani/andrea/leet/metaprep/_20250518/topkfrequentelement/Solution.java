package name.lorenzani.andrea.leet.metaprep._20250518.topkfrequentelement;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> values = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            values.computeIfPresent(nums[i], (key,value) -> value+1);
            values.putIfAbsent(nums[i], 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> ordered = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> value : values.entrySet()) {
            ordered.add(value);
            if(ordered.size()>k) {
                ordered.poll();
            }
        }
        int[] result = new int[k];
        int elem = 0;
        for(Map.Entry<Integer, Integer> val : ordered) {
            result[elem] = val.getKey();
            elem++;
        }
        return result;
    }
}
