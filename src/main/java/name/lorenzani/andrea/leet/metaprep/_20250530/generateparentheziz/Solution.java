package name.lorenzani.andrea.leet.metaprep._20250530.generateparentheziz;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    /*
    * ()
    * (())     ()()
    * ((()))   (()())   (())()  ()(())    ()()()
    *
    * */

    public List<String> generateParenthesis(int n) {
        if(n==1) return new ArrayList<>(List.of("()"));
        Set<String> res = new HashSet<>();
        ArrayList<String> prev = (ArrayList<String>) generateParenthesis(n-1);
        for(String par: prev) {
            res.add("("+par+")");
            res.add("()"+par);
            res.add(par+"()");
            String[] parGroup = split(par);
            if(parGroup.length == 1) continue;
            for(int i=0; i< parGroup.length; i++) {
                StringBuilder sb = new StringBuilder();
                StringBuilder prevSb = new StringBuilder();
                StringBuilder nextSb = new StringBuilder();
                for(int j=0; j<parGroup.length; j++) {
                    if(j==i) {
                        sb.append("(").append(parGroup[j]).append(")");
                        prevSb.append("()").append(parGroup[j]);
                        nextSb.append(parGroup[j]).append("()");
                    }
                    else {
                        sb.append(parGroup[j]);
                        prevSb.append(parGroup[j]);
                        nextSb.append(parGroup[j]);
                    }
                }
                res.add(sb.toString());
                res.add(prevSb.toString());
                res.add(nextSb.toString());
            }
        }

        return new ArrayList<>(res);
    }

    private String[] split(String s) {
        ArrayList<String> result = new ArrayList<>();
        Stack<Character> chars = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') chars.push('(');
            else chars.pop();
            sb.append(s.charAt(i));
            if(chars.empty()) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        String[] strings = result.toArray(new String[0]);
        return strings;
    }

}
