package name.lorenzani.andrea.leet.interview150.substringconcatenate;

import java.util.*;

public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> solution = new ArrayList<>();
        int lenString = words[0].length();
        Map<String, Integer> allStrings = new HashMap<>();
        for(String str: words){
            allStrings.compute(str, (key, value) -> (value==null)?1:value+1);
        }
        for(int k=0; k<lenString; k++) {
            Map<String, Integer> outWindow = new HashMap<>(allStrings);
            int start = k;
            int remain = words.length;
            for(int i=k; i+lenString<=s.length(); i=i+lenString){
                String consider = s.substring(i, i+lenString);
                if(outWindow.getOrDefault(consider, 0) < 1){
                    for(; start <= i; start = start+lenString){
                        String add = s.substring(start, start+lenString);
                        if(add.equals(consider)&&allStrings.containsKey(add)){
                            start += lenString;
                            break;
                        }
                        else if(allStrings.containsKey(add) &&
                                allStrings.get(add)>outWindow.get(add)) {
                            outWindow.compute(add, (key, value) -> value+1);
                            remain++;
                        }
                    }
                }
                else if(outWindow.containsKey(consider)) {
                    outWindow.compute(consider, (key, value) -> value-1);
                    remain--;
                }
                if(remain==0) solution.add(start);
            }
        }
        return solution;
    }

}
