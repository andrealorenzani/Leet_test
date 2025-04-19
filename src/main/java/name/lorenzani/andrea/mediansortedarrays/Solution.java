package name.lorenzani.andrea.mediansortedarrays;

public class Solution {
    int expectedPosition = -1;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        expectedPosition = ((nums1.length + nums2.length) / 2)
                + ((nums1.length + nums2.length) % 2)
                - (nums1.length == 0 ? 0 : 1)
                - (nums2.length == 0 ? 0 : 1);

        int pos1 = (nums1.length-1)/2;
        int pos2 = expectedPosition - pos1;
        if(nums1.length == 0)
            return median(0, nums1, expectedPosition, nums2);
        if(nums2.length == 0)
            return median(expectedPosition, nums1, 0, nums2);
        while(pos1+pos2 - expectedPosition <= 1) {
            if(nums1[pos1] > nums2[pos2]) {
                // Check the two are consecutive
                if((pos2 + 1 == nums2.length || nums2[pos2+1] >= nums1[pos1]) &&
                        (pos1 - 1 == -1 || nums1[pos1-1] <= nums2[pos2]) ) {
                    return median(pos1, nums1, pos2, nums2);
                }
                // They are not . progress
                pos2 += (nums2.length-pos2)/2;
                if(pos1 == expectedPosition - pos2) {
                    return median(pos1, nums1, pos2, nums2);
                }
                pos1 = Math.max(0,expectedPosition - pos2);
            }
            else {
                if((pos1 + 1 == nums1.length || nums1[pos1+1] >= nums2[pos2]) &&
                        (pos2 - 1 == -1 || nums2[pos2-1] <= nums1[pos1]) ) {
                    return median(pos1, nums1, pos2, nums2);
                }
                pos1 += (nums1.length-pos1)/2;
                if(pos2 == expectedPosition - pos1) {
                    return median(pos1, nums1, pos2, nums2);
                }
                pos2 = Math.max(0,expectedPosition - pos1);
            }
        }
        return median(pos1, nums1, pos2, nums2);
    }
    public double median(int pos1, int[] nums1, int pos2, int[] nums2) {
        boolean isExactNumber = (nums1.length + nums2.length) % 2 == 1;
        if(pos1 >= nums1.length) {
            pos1 = nums1.length - (nums1.length == 0 ? 0: 1);
            return nums2[expectedPosition-pos1];
        }
        if(pos2 >= nums2.length) {
            pos2 = nums2.length - (nums2.length == 0 ? 0: 1);
            return nums1[expectedPosition-pos2];
        }
        if(nums1[pos1] > nums2[pos2]) {
            if(isExactNumber) return nums1[pos1];
            else {
                if (pos2+1 < nums2.length && pos1+1 < nums1.length)
                    return ((double)Math.min(nums1[pos1+1], nums2[pos2+1])+(double) nums1[pos1])/2d;
                if (pos2+1 == nums2.length)
                    return (((double) nums1[pos1+1])+(double) nums1[pos1])/2d;
                if (pos1+1 == nums1.length)
                    return (((double) nums2[pos2+1])+(double) nums1[pos1])/2d;
            }
        }
        else {
            if(isExactNumber) return nums2[pos2];
            else {
                if (pos1+1 < nums1.length && pos2+1 < nums2.length)
                    return ((double)Math.min(nums1[pos1+1], nums2[pos2+1])+(double) nums2[pos2])/2d;
                if (pos2+1 == nums2.length)
                    return (((double) nums1[pos1+1])+(double) nums2[pos2])/2d;
                if (pos1+1 == nums1.length)
                    return (((double) nums2[pos2+1])+(double) nums2[pos2])/2d;
            }
        }
        return -1;
    }
}
