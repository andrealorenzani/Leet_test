package name.lorenzani.andrea.leet.median_two_sorted_array;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays(nums1, 0, nums1.length, nums2, 0, nums2.length);
    }

    // https://leetcode.com/problems/median-of-two-sorted-arrays/description/
    public double findMedianSortedArrays(int[] first, int firstx, int firsty,
                                         int[] second, int secondx, int secondy) {
        int pos1 = (first.length + second.length) / 2;
        int pos2 = pos1 + 1;
        if(first[firsty]<second[secondx]) {
            return 0;
        }
        return -1;
    }
}

/*
* 1,3,4,7,8,9
* 10,11,19,24,25*
* *
*
* 1,3,5,7
* 2,4,6,8
*
* 4 5
*
* 1 2 3   4 6 7 8
* 5
*
* 4,5
* */