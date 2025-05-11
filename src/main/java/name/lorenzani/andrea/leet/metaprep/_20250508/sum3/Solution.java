package name.lorenzani.andrea.leet.metaprep._20250508.sum3;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Triplet> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++) {
            if(i>1 && nums[i]==nums[i-1]) continue;
            for(int j=i+1; j< nums.length-1; j++) {
                if(nums[i]+nums[j]>0) break;
                if(i<j-1 && nums[j]==nums[j-1]) continue;
                int valij = nums[i] + nums[j];
                int valK = -valij;
                if(valK==nums[j] && nums[j+1]>valK) break;
                if(Arrays.binarySearch(nums, j+1, nums.length, valK)>0){
                    result.add(new Triplet(nums[i], nums[j], valK));
                }
            }
        }
        return result.stream().map(Triplet::get).collect(Collectors.toList());
    }

}

class Triplet {
    int x,y,z;

    public Triplet(int x, int y, int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public List<Integer> get() {
        return List.of(x,y,z);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triplet triplet = (Triplet) o;

        if (x != triplet.x) return false;
        if (y != triplet.y) return false;
        return z == triplet.z;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }
}
