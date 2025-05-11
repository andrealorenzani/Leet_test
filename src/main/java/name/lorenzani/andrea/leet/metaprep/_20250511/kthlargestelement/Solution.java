package name.lorenzani.andrea.leet.metaprep._20250511.kthlargestelement;

import java.util.PriorityQueue;
import java.util.TreeSet;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> values = new PriorityQueue<>();
        for(int i=0; i<nums.length; i++) {
            if(values.size()<k||nums[i]>values.peek()){
                values.add(nums[i]);
            }
            if(values.size()>k) values.poll();
        }
        return values.poll();
    }
}
