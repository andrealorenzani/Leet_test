package name.lorenzani.andrea.leet.interview150.median_two_sorted_array;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /*int medianLength = (nums1.length+ nums2.length)/2;
        boolean isAverage = (nums1.length+ nums2.length)%2==0;
        if(isAverage) medianLength--;

        if(nums1.length==0) return median(nums1, -1, nums2, medianLength, isAverage);
        if(nums2.length==0) return median(nums1, medianLength, nums2, -1, isAverage);

        int pos1=medianLength;
        int pos2=-1;
        while(!checkTheyAreNext(nums1, pos1, nums2, pos2)) {
            if(pos1 < 0) {
                return median(nums1, -1, nums2, medianLength, isAverage);
            }
            if(pos1 >= nums1.length) {
                return median(nums1, -1, nums2, medianLength-nums1.length, isAverage);
            }
            if(pos2 < 0) {
                return median(nums1, medianLength, nums2, -1, isAverage);
            }
            if(pos2 >= nums2.length) {
                return median(nums1, medianLength-nums2.length, nums2, -1, isAverage);
            }

        }
        return median(nums1, pos1, nums2, pos2, isAverage);*/
        /*int pos1 = nums1.length/2;
        int pos2 = medianLength-pos1;
        while(!checkTheyAreNext(nums1, pos1, nums2, pos2)) {
            if(pos1 < 0) {
                return median(nums1, -1, nums2, medianLength, isAverage);
            }
            if(pos1 >= nums1.length) {
                return median(nums1, -1, nums2, medianLength-nums1.length, isAverage);
            }
            if(pos2 < 0) {
                return median(nums1, medianLength, nums2, -1, isAverage);
            }
            if(pos2 >= nums2.length) {
                return median(nums1, medianLength-nums2.length, nums2, -1, isAverage);
            }
            if(nums1[pos1]>nums2[pos2]){
                pos1 = pos1/2;
                pos2 = medianLength-pos1;
            }
            else {
                pos1 = pos1*3/2;
                pos2 = medianLength-pos2;
            }
        }
        return median(nums1, pos1, nums2, pos2, isAverage);*/
        return 1;
    }

    public boolean checkTheyAreNext(int[] nums1, int pos1, int[] nums2, int pos2) {
        if(pos1<0 || pos1>=nums1.length || pos2<0 || pos2>= nums2.length) return false;
        if(nums1[pos1]<nums2[pos2]) {
            if(pos1+1<nums1.length && nums1[pos1+1]<nums2[pos2]) return false;
            if(pos2-1>=0 && nums2[pos2-1]>nums1[pos1]) return false;
            return true;
        }
        else {
            if(pos2+1<nums2.length && nums2[pos2+1]<nums1[pos1]) return false;
            if(pos1-1>=0 && nums1[pos1-1]>nums2[pos2]) return false;
            return true;
        }
    }

    public double median(int[] nums1, int pos1, int[] nums2, int pos2, boolean isAverage) {
        if(pos1<0 || pos1>= nums1.length) {
            if(isAverage) {
                return (nums2[pos2]+nums2[pos2+1])/2d;
            }
            else return nums2[pos2];
        }
        if(pos2<0 || pos2>= nums2.length) {
            if(isAverage) {
                return (nums1[pos1]+nums1[pos1+1])/2d;
            }
            else return nums1[pos1];
        }
        if(isAverage) {
            return (nums1[pos1]+nums2[pos2])/2d;
        }
        else return Math.min(nums1[pos1], nums2[pos2]);
    }
}