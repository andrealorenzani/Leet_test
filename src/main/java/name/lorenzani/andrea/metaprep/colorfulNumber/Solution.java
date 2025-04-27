package name.lorenzani.andrea.metaprep.colorfulNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static boolean colorfulNumber(int num) {
        HashSet<Integer> colorMap = new HashSet<>();
        String numStr = String.valueOf(num);
        for(int len = 0; len < numStr.length(); len++) {
            int acc = 1;
            for(int j = len; j<numStr.length(); j++) {
                acc = acc * (numStr.charAt(j)-'0');
                if(colorMap.contains(acc)) return false;
                colorMap.add(acc);
            }
        }
        return true;
    }



}
