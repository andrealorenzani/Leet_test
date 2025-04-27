package name.lorenzani.andrea.leet.interview150.MinimumSizeSubarraySum;

import java.util.Comparator;
import java.util.TreeMap;

public class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int valueOfWindow=0;
        int result = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            valueOfWindow += nums[i];
            if(valueOfWindow>=target) {
                for(;start<=i; start++){
                    if(valueOfWindow-nums[start]>=target){
                        valueOfWindow -= nums[start];
                        continue;
                    }
                    else {
                        result = Math.min(i-start+1, result);
                        break;
                    }
                }
            }
        }
        if(result == Integer.MAX_VALUE) return 0;
        return result;
    }
    public int minSubArrayLen_bruteforce(int target, int[] nums) {
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            int curr = 0;
            for(int j=i; j <= nums.length-1; j++) {
                curr += nums[j];
                if(result>0 && j-i >= result) break;
                if(curr >= target) {
                    result = j-i+1;
                    break;
                }
                if(j== nums.length-1) return result;
            }
        }
        return result;
    }

}
