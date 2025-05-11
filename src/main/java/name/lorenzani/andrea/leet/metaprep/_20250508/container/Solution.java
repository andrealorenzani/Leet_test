package name.lorenzani.andrea.leet.metaprep._20250508.container;

class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        for(int i=0; i<height.length; i++) {
            if(height[i] * (height.length-1-i) < result) continue;
            for(int j= height.length-1; j>i; j--) {
                if(height[i] * (j-i) < result) break;
                int val = Math.min(height[i], height[j]) * (j-i);
                result = Math.max(result, val);
            }
        }
        return result;
    }
}
