package name.lorenzani.andrea.leet.leet_3;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] array = s.toCharArray();
        int start = 0;
        int end = 0;
        HashSet<Character> chars = new HashSet<>(array.length);
        int max = 0;
        for(; end<array.length; end++) {
            if(chars.contains(array[end])) {
                for(; start<end; start++) {
                    chars.remove(array[start]);
                    if(array[start] == array[end]){
                        start = start + 1;
                        break;
                    }
                }
            }
            chars.add(array[end]);
            max = (chars.size()>max)? chars.size():max;
        }
        return max;
    }
}
