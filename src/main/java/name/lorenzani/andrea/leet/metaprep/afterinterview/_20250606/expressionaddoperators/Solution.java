package name.lorenzani.andrea.leet.metaprep.afterinterview._20250606.expressionaddoperators;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public List<String> addOperators(String num, int target) {
        return addOperators(num, target, 0, 0, "");
    }

    public List<String> addOperators(String num, int target, int start, int lastVal, String lastStr) {
        if(start>=num.length()) return new ArrayList<>();
        int currVal = 0;
        ArrayList<String> result = new ArrayList<>();
        for(int i=start; i<num.length(); i++) {
            if(i==num.length()-1) {
                if(target==currVal+lastVal) result.add(lastStr + "+" + currVal);
                if(target==lastVal-currVal) result.add(lastStr + "-" + currVal);
                if(target==lastVal*currVal) result.add(lastStr + "*" + currVal);
            }
            else {
                currVal = currVal * 10 + (num.charAt(i) - '0');
                List<String> currRes = addOperators(num, target - lastVal, i + 1, currVal, String.valueOf(currVal));
                if (start == 0) result.addAll(currRes);
                else result.addAll(currRes.stream().map(value -> lastStr + "+" + value).toList());
                currRes = addOperators(num, target + lastVal, i + 1, currVal, String.valueOf(currVal));
                if (start == 0) result.addAll(currRes);
                else result.addAll(currRes.stream().map(value -> lastStr + "-" + value).toList());
                currRes = addOperators(num, target, i + 1, lastVal * currVal, ((start != 0) ? lastStr + "*" : "") + currVal);
                result.addAll(currRes);
            }
        }
        return result;
    }
}
