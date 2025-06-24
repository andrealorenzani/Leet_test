package name.lorenzani.andrea.leet.metaprep._20250528.mediansortedarray;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenConcatArray = nums1.length + nums2.length;
        int medPosition = lenConcatArray / 2;
        int[] positions = new int[] {0, nums1.length-1, 0, nums2.length-1};
        return 0d;
    }

    private int[] find(int[] nums1, int[] nums2, int[] pos, int target) {
        return null;
    }

}
