package name.lorenzani.andrea.leet.interview150.textjustification_68;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>(words.length);
        int currLine = 0;
        List<String> support = new ArrayList<>(words.length);
        for (String word: words) {
            if(currLine+word.length()>maxWidth) {
                result.add(computeNewLine(support, currLine-1, maxWidth));
                currLine = word.length()+1;
                support = new ArrayList<>();
                support.add(word);
            }
            else {
                currLine += word.length()+1;
                support.add(word);
            }
        }
        result.add(computeFinalLine(support, maxWidth));
        return result;
    }

    public String computeNewLine(List<String> support, int currLine, int maxWidth) {
        int spaces = support.size() <= 1 ? maxWidth-currLine : ((maxWidth-currLine)/(support.size()-1))+1;
        int spacesPlusOne = support.size() <= 1 ? 0: (maxWidth-currLine)%(support.size()-1);
        StringBuffer sb = new StringBuffer();
        int curr = 0;
        for(String word: support) {
            sb.append(word);
            curr += 1;
            if(curr==1 || curr<support.size()) {
                if (curr <= spacesPlusOne) {
                    sb.append(" ".repeat(spaces + 1));
                } else {
                    sb.append(" ".repeat(spaces));
                }
            }
        }
        return sb.toString();
    }
    public String computeFinalLine(List<String> support, int maxWidth) {
        StringBuffer sb = new StringBuffer();
        int curr = 0;
        for(String word: support) {
            sb.append(word);
            if(curr+1 < support.size()) {
                sb.append(" ");
            }
            else {
                sb.append(" ".repeat(maxWidth - sb.length()));
            }
            curr += 1;
        }
        return sb.toString();
    }
}
