package name.lorenzani.andrea.leet.interview150.removeduplicatefromsortedarray2;

class Solution {
    public int removeDuplicates(int[] nums) {
        int nextToWrite = 0;
        int curr = Integer.MIN_VALUE;
        int repet = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==curr && repet >=2) continue;
            nums[nextToWrite] = nums[i];
            nextToWrite++;
            if(curr == nums[i]) repet++;
            else repet = 1;
            curr = nums[i];
        }
        return nextToWrite;
    }
}
