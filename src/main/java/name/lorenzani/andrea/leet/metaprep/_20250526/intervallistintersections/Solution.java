package name.lorenzani.andrea.leet.metaprep._20250526.intervallistintersections;

import java.util.ArrayList;

public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length==0 || secondList.length ==0) return new int[][] {};
        int pointerFirst = 0; int pointerSec = 0;
        ArrayList<int[]> result = new ArrayList<>();
        while(pointerFirst <= firstList.length-1 && pointerSec <= secondList.length-1) {
            if(firstList[pointerFirst][1] < secondList[pointerSec][0]) {
                pointerFirst++;
            }
            else if(firstList[pointerFirst][0] > secondList[pointerSec][1]) {
                pointerSec++;
            }
            else {
                int intersStart = Math.max(firstList[pointerFirst][0], secondList[pointerSec][0]);
                int intersEnd = Math.min(firstList[pointerFirst][1], secondList[pointerSec][1]);
                if(intersEnd>=intersStart) result.add(new int[]{intersStart, intersEnd});
                if(intersEnd == firstList[pointerFirst][1]) pointerFirst++;
                else pointerSec++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
