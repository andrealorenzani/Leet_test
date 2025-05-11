package name.lorenzani.andrea.leet.metaprep._20250510.simplifypath;

import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public String simplifyPath(String path) {
        LinkedList<String> result = new LinkedList<>();
        String[] input = path.split("/");
        for(String dir: input) {
            if(dir == null || dir.isEmpty() || dir.equals(".")) continue;
            if(dir.equals("..")){
                if(result.size()>0) result.removeLast();
                continue;
            }
            result.addLast(dir);
        }
        return "/" + result.stream().collect(Collectors.joining("/"));
    }

}
