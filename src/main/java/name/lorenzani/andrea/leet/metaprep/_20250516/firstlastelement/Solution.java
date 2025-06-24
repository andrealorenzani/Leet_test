package name.lorenzani.andrea.leet.metaprep._20250516.firstlastelement;

public class Solution {

        public int[] searchRange(int[] nums, int target) {
            return search(target, nums, 0, nums.length-1);
        }

        protected int[] search(int target, int[] nums, int start, int end) {
            if(start>end) return new int[]{-1,-1};
            int pivot = (start+end)/2;
            if(nums[pivot]==target){
                start = pivot;
                end = pivot;
                while(start>=0 && nums[start]==target) {
                    start--;
                }
                while(end<nums.length && nums[end]==target) {
                    end++;
                }
                return new int[]{start+1, end-1};
            }
            if(nums[pivot]<target) {
                return search(target, nums, pivot+1, end);
            }
            else {
                return search(target, nums, start, pivot-1);
            }
        }

}
