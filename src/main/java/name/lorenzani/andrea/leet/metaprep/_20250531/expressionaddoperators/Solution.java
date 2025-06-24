package name.lorenzani.andrea.leet.metaprep._20250531.expressionaddoperators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public List<String> addOperators(String num, int target) {
        List<String> res = subProblem(num, 0, 0, target);
        return res.stream().filter(x -> x.charAt(0) != '*').map(x -> x.substring(1)).toList();
    }

    public List<String> subProblem(String num, int lastVal,  int pos, int target) {
        ArrayList<String> res = new ArrayList<>();
        /*if(pos==num.length()-1) {
            if(lastVal+(num.charAt(pos)-'0') == target) {
                res.add(String.format("%d+%d", lastVal, (num.charAt(pos)-'0')));
            }
            if(lastVal*(num.charAt(pos)-'0') == target) {
                res.add(String.format("*%d", (num.charAt(pos)-'0')));
            }
            if(lastVal-(num.charAt(pos)-'0') == target) {
                res.add(String.format("-%d", (num.charAt(pos)-'0')));
            }
            return res;
        }
        int value = 0;
        int precomputedVal = 0; // to fix compilation
        for(int i=pos;i<num.length()-1; i++) {
            value = value*10 + (num.charAt(i)-'0');
            final String valueStr = String.valueOf(value);
            List<String> subVals = subProblem(num, precomputedVal+value, value,i+1, target);
            res.addAll(subVals.stream().map(x -> String.format("+%s%s", valueStr, x)).toList());
            if(i!=0) {
                subVals = subProblem(num, (precomputedVal-lastVal)+(lastVal*value), value, i+1, target-precomputedVal);
                res.addAll(subVals.stream().map(x -> String.format("*%s%s", valueStr, x)).toList());
                subVals = subProblem(num, precomputedVal - value, value, i + 1, target);
                res.addAll(subVals.stream().map(x -> String.format("-%s%s", valueStr, x)).toList());
            }
            if(i==pos && value == 0) break;
        }*/
        return res;
    }


    class Result {
        int value;
        String ops;

        public Result(int value, String ops) {
            this.value=value;
            this.ops=ops;
        }
    }
}
