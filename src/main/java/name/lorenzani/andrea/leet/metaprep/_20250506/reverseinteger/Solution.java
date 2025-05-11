package name.lorenzani.andrea.leet.metaprep._20250506.reverseinteger;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public int reverse(int x) {
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        while(x!=0) {
            if(result>(Integer.MAX_VALUE/10) ||
                    (result==(Integer.MAX_VALUE/10) && (x%10)>(Integer.MAX_VALUE%10))) return 0;
            if(result<(Integer.MIN_VALUE/10) ||
                    (result==(Integer.MIN_VALUE/10) && (x%10)<(Integer.MIN_VALUE%10))) return 0;
            result = (result*10) + x%10;
            x=x/10;
        }
        return result;
    }

}
