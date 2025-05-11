package name.lorenzani.andrea.leet.metaprep._20250511.findpeak;

public class Solution {
    public int findPeakElement(int[] nums) {
        return findPeakElement(nums, 0, nums.length-1);
    }

    public int findPeakElement(int[] nums, int start, int end) {
        int selected = (start + end) / 2;
        int isPeak = isPeak(nums, selected);
        if(isPeak == 0) {
            return selected;
        }
        if(isPeak > 0){
            return findPeakElement(nums, selected+1, end);
        }
        else {
            return findPeakElement(nums, start, selected-1);
        }
    }

    public int isPeak(int[] nums, int pos) {
        if(pos<0) return 1;
        if(pos>=nums.length) return -1;
        if(pos>0 && nums[pos]<=nums[pos-1]) return -1;
        if(pos<nums.length-1 && nums[pos]<=nums[pos+1]) return 1;
        return 0;
    }
}
