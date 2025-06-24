package name.lorenzani.andrea.leet.metaprep._20250513.minimumremoveparenthesis;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public String minRemoveToMakeValid(String s) {
        LinkedList<Integer> removable = new LinkedList<>();
        char[] chars = s.toCharArray();
        for(int i=0; i< chars.length; i++){
            switch(chars[i]){
                case '(' -> { removable.push(i); break; }
                case ')' -> {
                    if(removable.size()>0 && chars[removable.peek()] == '('){
                        removable.pop();
                    }
                    else removable.push(i);
                }
                default -> {}
            }
        }
        if(removable.size()==0) return s;
        StringBuilder res = new StringBuilder(chars.length-removable.size());
        int nextToSkip = removable.pollLast();
        for(int i=0; i<chars.length; i++) {
            if(i!=nextToSkip) res.append(chars[i]);
            else {
                if(removable.size()>0) nextToSkip=removable.pollLast();
            }
        }
        return res.toString();
    }
}
