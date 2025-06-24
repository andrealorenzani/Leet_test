package name.lorenzani.andrea.leet.metaprep._20250526.maxconsecutiveones3;

public class Solution {

    public int longestOnes(int[] nums, int k) {
        if(nums.length<k) return nums.length;
        int max = 0;
        int start = 0;
        int end = 0;
        int flipped = 0;
        for(int i=0; i< nums.length; i++) {
            if(nums[i]==1) end = i;
            else {
                if(flipped < k) {
                    flipped++;
                    end = i;
                }
                else if(nums[start]==0){
                    start++;
                    end = i;
                }
                else {
                    max = Math.max(max, end-start+1);
                    while(nums[start]==1) {
                        start++;
                    }
                    start++;
                }
            }
            if(i== nums.length-1) max = Math.max(max, end-start+1);
        }
        return max;
    }

}
