package name.lorenzani.andrea.leet.metaprep._20250513.continuoussubarraysum;

import java.util.HashSet;

public class Solution {
    public boolean checkSubarraySumBruteForce(int[] nums, int k) {

        for(int i=0; i<nums.length-1; i++) {
            int subVal=0;
            for(int j=i;j<nums.length; j++) {
                subVal += nums[j];
                if(subVal%k==0 && j-i>=1) return true;
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {

        HashSet<Integer> visited = new HashSet<>();
        int val = nums[0];
        for(int i=1;i< nums.length; i++) {
            int tbadded = val%k;
            val = (val + nums[i]) % k;
            if(val==0 || visited.contains(val)) return true;
            visited.add(tbadded);
        }
        return false;
    }
}
