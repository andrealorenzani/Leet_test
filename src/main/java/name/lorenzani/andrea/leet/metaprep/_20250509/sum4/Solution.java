package name.lorenzani.andrea.leet.metaprep._20250509.sum4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public List<List<Integer>> fourSumWithoutSort(int[] nums, int target) {
        HashSet<Quadruplet> result = new HashSet<>();
        for(int a=0;a<nums.length-3;a++){
            for(int d=nums.length-1;d>a+2; d--){
                int b = a+1, c = d-1;
                while(b<c){
                    long val = (long)nums[a] + (long)nums[b] + (long)nums[c] + (long)nums[d];
                    if(val==(long)target){
                        result.add(new Quadruplet(nums[a], nums[b], nums[c], nums[d]));
                        if(nums[b]>nums[c]) b++;
                        else c--;
                    }
                    else if(val<target){
                        if(nums[b]>nums[c]) c--;
                        else b++;
                    }
                    else {
                        if(nums[b]>nums[c]) b++;
                        else c--;
                    }
                }
            }
        }
        return result.stream().map(Quadruplet::get).collect(Collectors.toList());
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<Quadruplet> result = new HashSet<>();
        for(int a=0;a<nums.length-3;a++){
            for(int d=nums.length-1;d>a+2; d--){
                int b = a+1, c = d-1;
                while(b<c){
                    long val = (long)nums[a] + (long)nums[b] + (long)nums[c] + (long)nums[d];
                    if(val==(long)target){
                        result.add(new Quadruplet(nums[a], nums[b], nums[c], nums[d]));
                        b++;c--;
                    }
                    else if(val<target){
                        b++;
                    }
                    else c--;
                }
            }
        }
        return result.stream().map(Quadruplet::get).collect(Collectors.toList());
    }
}

class Quadruplet {
    int a,b,c,d;
    public Quadruplet(int a, int b, int c, int d){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }

    public List<Integer> get() {
        return List.of(a,b,c,d);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quadruplet that = (Quadruplet) o;

        if (a != that.a) return false;
        if (b != that.b) return false;
        if (c != that.c) return false;
        return d == that.d;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        result = 31 * result + d;
        return result;
    }
}
