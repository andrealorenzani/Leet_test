package name.lorenzani.andrea.leet.metaprep._20250518.subarraysumequalsk;

import java.util.HashMap;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        int value = 0;
        int count = 0;
        HashMap<Integer, Integer> prevVals = new HashMap<>();
        prevVals.put(0, 1);
        for(int i=0; i< nums.length; i++) {
            value += nums[i];
            prevVals.putIfAbsent(value, 0);
            count += prevVals.getOrDefault(value-k, 0);
            prevVals.compute(value, (key, val) -> val +1);
        }
        return count;
    }

}
