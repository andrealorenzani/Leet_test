package name.lorenzani.andrea.leet.metaprep._20250603.textjustification;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int start = 0;
        int length = 0;
        for(int i=0; i< words.length; i++) {
            int currW = words[i].length();
            if(length + 1 + currW <= maxWidth) {
                length += currW + ((i==0)?0:1);
            }
            else {
                res.add(computeJustifiedLine(start, i-1, length, maxWidth, words));
                start = i;
                length = currW;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=start; i < words.length; i++) {
            if(i==start) {
                sb.append(words[i]);
                maxWidth -= words[i].length();
            }
            else {
                sb.append(" ").append(words[i]);
                maxWidth -= 1 + words[i].length();
            }
        }
        sb.append(String.join("", Collections.nCopies(maxWidth, " ")));
        res.add(sb.toString());
        return res;
    }

    private String computeJustifiedLine(int start, int end, int length, int maxWidth, String[] words) {
        int interWords = end - start;
        StringBuilder sb = new StringBuilder();
        if(interWords == 0) {
            sb.append(words[start]);
            sb.append(String.join("", Collections.nCopies(maxWidth - words[start].length(), " ")));
            return sb.toString();
        }
        int minSpaces = ((maxWidth-length) / interWords)+1;
        int spacesPlusOne = (maxWidth - length) % interWords;

        for(int i=start; i<=end; i++) {
            if(i==start) sb.append(words[i]);
            else {
                int spaces = minSpaces + ((spacesPlusOne>0)?1:0);
                spacesPlusOne--;
                sb.append(String.join("", Collections.nCopies(spaces, " "))).append(words[i]);
            }
        }
        return sb.toString();
    }

}
