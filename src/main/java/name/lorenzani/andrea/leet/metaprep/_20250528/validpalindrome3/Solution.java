package name.lorenzani.andrea.leet.metaprep._20250528.validpalindrome3;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {

    HashMap<DynamicValue, DynamicValue> dynamic;

    public boolean isValidPalindrome(String s, int k) {
        dynamic = new HashMap<>();
        int minPal = s.length()-k;
        if(minPal<0) return true;
        char[] sAsC = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
            if(checkKPalindrom(sAsC, i, i, k)) {
                return true;
            }
            if(checkKPalindrom(sAsC, i, i+1, k)) {
                return true;
            }
        }
        return false;
    }
    private boolean checkKPalindrom(char[] palin, int start, int end, int k){
        if(k<0) return false;
        if(k > palin.length-(end-start)) return true;
        if(start<0 && end == palin.length) return true;
        if((start>=0 && end == palin.length) ||
                (start<0 && end < palin.length)) return false;
        DynamicValue thisRec = new DynamicValue(start, end, k, true);
        DynamicValue prev = dynamic.get(thisRec);
        if(prev != null && prev.k >= k && !prev.isPalindrome) return false;
        if(prev != null && prev.k <= k && prev.isPalindrome) return true;
        if(palin[start] == palin[end]) thisRec.isPalindrome = checkKPalindrom(palin, start-1, end+1, k);
        else thisRec.isPalindrome = checkKPalindrom(palin, start-1, end, k-1) || checkKPalindrom(palin, start, end+1, k-1);
        dynamic.put(thisRec, thisRec);
        return thisRec.isPalindrome;
    }

    public boolean isValidPalindromeOld(String s, int k) {
        dynamic = new HashMap<>();
        return checkKPalindrom(s.toCharArray(), 0, s.length()-1, k);
    }

    private boolean checkKPalindromOld(char[] palin, int start, int end, int k){
        if(k<0) return false;
        if(k>end-start-1) return true;
        if(palin==null || palin.length==1 || start==end) return true;
        if(end-start==1 && palin[start] == palin[end]) return true;
        DynamicValue thisValue = new DynamicValue(start, end, k, true);
        DynamicValue prev = dynamic.get(thisValue);
        if(prev != null && prev.k >= k && !prev.isPalindrome) return false;
        if(prev != null && prev.k <= k && prev.isPalindrome) return true;
        if(palin[start] == palin[end]) thisValue.isPalindrome = checkKPalindrom(palin, start+1, end-1, k);
        else thisValue.isPalindrome = checkKPalindrom(palin, start+1, end, k-1) || checkKPalindrom(palin, start, end-1, k-1);
        return thisValue.isPalindrome;
    }

}

class DynamicValue {
    int start;
    int end;
    int k;
    boolean isPalindrome;

    public DynamicValue(int start, int end, int k, boolean isPalindrome) {
        this.start = start;
        this.end = end;
        this.k = k;
        this.isPalindrome = isPalindrome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DynamicValue that = (DynamicValue) o;

        if (start != that.start) return false;
        return end == that.end;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }
}
