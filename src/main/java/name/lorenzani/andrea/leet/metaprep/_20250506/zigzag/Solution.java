package name.lorenzani.andrea.leet.metaprep._20250506.zigzag;

import java.util.*;

public class Solution {

    public String convert(String s, int numRows) {
        if(numRows<2) return s;
        StringBuffer[] lines = new StringBuffer[numRows];
        int lineNum = 0;
        for(char x:s.toCharArray()) {
            if(lineNum<numRows) {
                if(Objects.isNull(lines[lineNum])) {
                    lines[lineNum] = new StringBuffer();
                }
                lines[lineNum].append(x);
            } else {
                lines[numRows-(lineNum%numRows)-2].append(x);
            }
            lineNum = (lineNum+1) % ((numRows*2)-2);
        }
        StringBuffer result = new StringBuffer();
        for(StringBuffer x:lines) {
            if(Objects.isNull(x)) return result.toString();
            result.append(x.toString());
        }
        return result.toString();
    }

}
