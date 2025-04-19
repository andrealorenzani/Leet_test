package name.lorenzani.andrea.leet.interview150.jumpGame;

public class Solution {

        public boolean canJump(int[] nums) {
            int max = nums[0];
            for(int i=0; i<=Math.min(max, nums.length-1); i++){
                if(max >= nums.length-1) return true;
                max = Math.max(max, i+nums[i]);
            }
            return false;
        }

}
