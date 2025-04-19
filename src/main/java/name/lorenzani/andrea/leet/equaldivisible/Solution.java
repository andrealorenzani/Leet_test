package name.lorenzani.andrea.leet.equaldivisible;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Solution {

    public int countPairs(int[] nums, int k) {
        HashMap<Integer, ArrayList<Integer> > values = new HashMap<>();
        int total = 0;
        for(int i=0; i<nums.length; i++) {
            ArrayList<Integer> prevVal = values.get(nums[i]);
            if(Objects.nonNull(prevVal)) {
                for(Integer j:prevVal) {
                    if((j*i)%k==0) total++;
                }
                prevVal.add(i);
            }
            else {
                ArrayList<Integer> newList = new ArrayList<>();
                newList.add(i);
                values.put(nums[i], newList);
            }
        }
        return total;
    }

}
