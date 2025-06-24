package name.lorenzani.andrea.leet.metaprep._20250518.customsortstring;

import java.util.HashMap;

public class Solution {
    public String customSortString(String order, String s) {
        int[] sOrder = new int[26];
        for(int i=0; i<s.length(); i++) {
            sOrder[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<order.length(); i++) {
            int nletters = sOrder[order.charAt(i)-'a'];
            sOrder[order.charAt(i)-'a'] = 0;
            sb.append(String.valueOf(order.charAt(i)).repeat(Math.max(0, nletters)));
        }
        for(int i=0; i<sOrder.length; i++) {
            int nletters = sOrder[i];
            char letter = (char) (i + 'a');
            sb.append(String.valueOf(letter).repeat(Math.max(0, nletters)));
        }
        return sb.toString();
    }
}
