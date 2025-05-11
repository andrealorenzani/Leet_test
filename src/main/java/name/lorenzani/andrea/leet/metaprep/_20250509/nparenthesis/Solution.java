package name.lorenzani.andrea.leet.metaprep._20250509.nparenthesis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;


////// TO BE CHECKED!!!

public class Solution {
    public List<String> generateParenthesis(int n) {
        if(n==1) return List.of("()");
        List<String> others = generateParenthesis(n-1);
        List<String> wrap = others.stream().map(val -> "("+val+")").collect(Collectors.toList());
        List<String> next = others.stream().map(val -> val+"()").collect(Collectors.toList());
        List<String> prev = others.stream().map(val -> "()"+val).collect(Collectors.toList());
        HashSet<String> values = new HashSet<>();
        values.addAll(wrap); values.addAll(next); values.addAll(prev);
        return new ArrayList<>(values);
    }
}