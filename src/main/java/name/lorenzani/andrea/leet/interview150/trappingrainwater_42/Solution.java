package name.lorenzani.andrea.leet.interview150.trappingrainwater_42;

class Solution {
    public int trap(int[] height) {
        int peak = height[0];
        int posPeak = 0;
        int possibleWater = 0;
        int total = 0;

        for(int i=1; i<height.length; i++) {
            if(height[i] < peak) {
                possibleWater += peak - height[i];
            }
            else {
                total += possibleWater;
                possibleWater = 0;
                peak = height[i];
                posPeak = i;
            }
        }
        peak = 0;
        possibleWater = 0;
        for(int i=height.length-1; i>=posPeak; i--) {
            if(height[i] < peak) {
                possibleWater += peak - height[i];
            }
            else {
                total += possibleWater;
                possibleWater = 0;
                peak = height[i];
            }
        }
        return total;
    }
}
