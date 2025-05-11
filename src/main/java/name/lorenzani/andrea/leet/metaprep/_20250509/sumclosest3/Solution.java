package name.lorenzani.andrea.leet.metaprep._20250509.sumclosest3;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MIN_VALUE;
        boolean first = true;
        for(int i=0; i < nums.length-2;i++) {
            for(int j= nums.length-1; j>i+1; j--){
                int localRes;
                int k = target - (nums[i]+nums[j]);
                int pos = Arrays.binarySearch(nums, i+1, j, k);
                if(pos>0) return target;
                else pos = pos+1;
                if(-pos>=j) pos=-(j-1);
                if(-pos<=i) pos=-(i+1);
                if(-pos>i+1){
                    k = nums[-pos];
                    if(Math.abs(target-(k+nums[i]+nums[j]))>Math.abs(target-(nums[-pos-1]+nums[i]+nums[j]))){
                        localRes = nums[-pos-1]+nums[i]+nums[j];
                    }
                    else localRes = k+nums[i]+nums[j];
                }
                else localRes = nums[-pos]+nums[i]+nums[j];
                result = (Math.abs(target-localRes)<Math.abs(target-result))||first?localRes:result;
                first = false;
            }
        }
        return result;
    }
}