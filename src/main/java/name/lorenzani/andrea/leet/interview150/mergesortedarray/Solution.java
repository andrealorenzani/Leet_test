package name.lorenzani.andrea.leet.interview150.mergesortedarray;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        for(int k = nums1.length-1; k>=0; k--) {
            if(j==-1 || (i>-1 && nums1[i]>nums2[j])){
                nums1[k] = nums1[i];
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }
}
