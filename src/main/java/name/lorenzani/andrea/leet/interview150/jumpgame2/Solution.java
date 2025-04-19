package name.lorenzani.andrea.leet.interview150.jumpgame2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    public int jump(int[] nums) {
        if(nums.length==1) return 0;
        int[] lastJump = new int[3];
        int jumps = 1;
        int max = nums[0];
        lastJump[0] = max;
        lastJump[1] = 0;
        lastJump[2] = -1;
        for(int i=0; i<=Math.min(max, nums.length-1); i++){
            if(i+nums[i] > max) {
                if(lastJump[1] + lastJump[0] >= i){
                    lastJump[2] = i;
                }
                else {
                    int start = lastJump[2];
                    lastJump[0] = nums[start];
                    lastJump[1] = start;
                    lastJump[2] = i;
                    jumps++;
                }
                max = i+nums[i];
            }
        }
        if(lastJump[0]+lastJump[1]<nums.length-1) {
            jumps++;
        }
        return jumps;
    }


    public int jump_brute(int[] nums) {
        if(nums.length==1) return 0;
        LinkedList<int[]> jumps = new LinkedList<>();
        int max = nums[0];
        jumps.addLast(new int[] {max, 0, -1});
        for(int i=0; i<=Math.min(max, nums.length-1); i++){
            if(i+nums[i] > max) {
                    if(jumps.getLast()[1] + jumps.getLast()[0] >= i){
                        jumps.getLast()[2] = i;
                    }
                    else {
                        int start = jumps.getLast()[2];
                        jumps.addLast(new int[]{nums[start], start, i});
                    }
                    max = i+nums[i];
            }
        }
        if(jumps.getLast()[0]+jumps.getLast()[1]<nums.length-1) {
            jumps.addLast(new int[]{nums[jumps.getLast()[2]], jumps.getLast()[2], -1});
        }
        return jumps.size();
    }
}
