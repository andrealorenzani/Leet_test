package name.lorenzani.andrea.leet.metaprep._20250520.buildingoceanview;

import java.util.Collections;
import java.util.Stack;

public class Solution {

    public int[] findBuildings(int[] heights) {
        Stack<Integer> buildings = new Stack<>();
        int max = -1;
        for(int i= heights.length-1;i>=0; i--) {
            if(heights[i]>max) {
                max = heights[i];
                buildings.push(i);
            }
        }
        int[] result = new int[buildings.size()];
        int pointer = 0;
        while(!buildings.isEmpty()) {
            result[pointer] = buildings.pop();
            pointer++;
        }
        return result;
    }

}
