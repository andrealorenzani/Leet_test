package name.lorenzani.andrea.hackajob.movie_collection;

import java.util.LinkedList;

public class Solution {

    public static String run(int n, int m, int[] movies) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=1; i<=n; i++) {
            stack.addLast(i);
        }

        StringBuffer res = new StringBuffer();

        for(int i=0; i<m; i++) {
            if(res.length()>0) res.append(",");
            int movieLabel = movies[i];
            int idx = stack.indexOf(movieLabel);
            res.append(idx);
            stack.remove(idx);
            stack.addFirst(movieLabel);
        }

        return res.toString();
    }

}
