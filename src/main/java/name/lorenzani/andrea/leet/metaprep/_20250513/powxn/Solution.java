package name.lorenzani.andrea.leet.metaprep._20250513.powxn;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {

    TreeMap<Long, Double> pows = new TreeMap<>(Comparator.reverseOrder());

    public double myPow(double x, int n) {
        return myPow(x, (long) n);
    }
    public double myPow(double x, long n) {
        if(n==1) return x;
        if(n==0) return 1;
        if(n<0) return 1/(myPow(x, -n/2)*(myPow(x, -n+n/2)));
        if(pows.containsKey(n)) return pows.get(n);
        Map.Entry<Long, Double> candidate = pows.ceilingEntry(n/2);
        if(candidate==null || candidate.getKey()*2<n/2) {
            double val = myPow(x, n / 2) * myPow(x, (n - n / 2));
            pows.put((long) n, val);
            return val;
        }
        else {
            return candidate.getValue() * myPow(x, n-candidate.getKey());
        }
    }

}
