package name.lorenzani.andrea.leet.metaprep._20250519.randompickwithweight;

import java.util.Random;
import java.util.TreeMap;

public class Solution {
    TreeMap<Integer, Integer> stats;
    int maxVal=0;

    public Solution(int[] w) {
        stats = new TreeMap<>();
        for(int i=0; i<w.length; i++) {
            maxVal = maxVal + w[i];
            stats.put(maxVal, i);
        }
    }

    public int pickIndex() {
        Random rand = new Random();
        int extracted = rand.nextInt(maxVal+1);
        return stats.ceilingEntry(extracted).getValue();
    }
}
