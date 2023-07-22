package name.lorenzani.andrea.leet.leet_287;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public class Solution {

    public static int findDuplicate(int[] nums) {
        int total = nums.length * Math.floorDiv(nums.length-1, 2);
        total = ((nums.length-1) % 2 == 0) ? total : (int)(total + (nums.length-1) / 2 + 1);
        int value = Arrays.stream(nums).reduce(0, Integer::sum);
        return value - total;
    }

}
