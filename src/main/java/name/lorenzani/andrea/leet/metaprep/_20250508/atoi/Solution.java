package name.lorenzani.andrea.leet.metaprep._20250508.atoi;

public class Solution {
    public int myAtoi(String s) {
        if(s == null) return 0;
        char[] working = s.strip().toCharArray();
        if(working.length == 0) return 0;
        int pos = 0;
        long result = 0;
        boolean positive = true;
        switch (working[0]) {
            case '-' -> {
                positive = false;
                pos++;
            }
            case '+' -> pos++;
            default -> {
            }
        }
        for(;pos < working.length; pos++) {
            if(working[pos] - '0' < 0 || working[pos] - '0' > 9) {
                return (int) (result*(positive?1:-1));
            }
            result = (result * 10) + (working[pos]-'0');
            if(Integer.MAX_VALUE<result && positive) return Integer.MAX_VALUE;
            if(Integer.MIN_VALUE>(result*-1) && !positive) return Integer.MIN_VALUE;
        }
        return (int) (result*(positive?1:-1));
    }

}
