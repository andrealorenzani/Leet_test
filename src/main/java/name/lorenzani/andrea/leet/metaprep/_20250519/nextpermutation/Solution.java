package name.lorenzani.andrea.leet.metaprep._20250519.nextpermutation;

import java.util.Arrays;

// 6,9,8,7,5

class Solution {
    public void nextPermutation(int[] nums) {
        int swapSmall, swapBig;
        for(int i=nums.length-2; i>=0; i--) {
            if(nums[i+1] > nums[i]) {
                swapSmall = i;
                swapBig = i+1;
                for(int j=swapBig; j<nums.length; j++) {
                    if(nums[j]>nums[i]){
                        swapBig = j;
                    }
                }
                int tmp = nums[swapBig];
                nums[swapBig] = nums[swapSmall];
                nums[swapSmall] = tmp;
                Arrays.sort(nums, i+1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }
}
