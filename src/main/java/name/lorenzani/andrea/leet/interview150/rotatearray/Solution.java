package name.lorenzani.andrea.leet.interview150.rotatearray;

class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0 || (k % nums.length) == 0) return;
        if(k>nums.length) k=k % nums.length;
        int[] value = new int[k];
        for(int i = 0; i<k; i++) {
            value[i] = nums[nums.length-k+i];
        }
        for(int i=nums.length-k-1; i>=0; i--) {
            nums[i+k] = nums[i];
        }
        for(int i = 0; i<k; i++) {
            nums[i] = value[i];
        }
    }

    public void rotate_space_o_of_n(int[] nums, int k) {
        if(k==0 || (k % nums.length) == 0) return;
        if(k>nums.length) k=k % nums.length;
        int[] value = new int[k];
        for(int i = 0; i<k; i++) {
            value[i] = nums[nums.length-k+i];
        }
        for(int i=nums.length-k-1; i>=0; i--) {
            nums[i+k] = nums[i];
        }
        for(int i = 0; i<k; i++) {
            nums[i] = value[i];
        }
    }
}

// 1,2,3    k = 5