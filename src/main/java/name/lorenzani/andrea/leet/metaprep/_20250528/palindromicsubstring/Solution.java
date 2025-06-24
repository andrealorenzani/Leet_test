package name.lorenzani.andrea.leet.metaprep._20250528.palindromicsubstring;

public class Solution {

    public int countSubstrings(String s) {
        // aandnn  bfgcg
        int res = 0;
        char[] sAsArray = s.toCharArray();
        for(int i=0; i<s.length(); i++) {
            res += checkPalindrome(i, i, sAsArray);
            res += checkPalindrome(i, i+1, sAsArray);
        }
        return res;
    }

    private int checkPalindrome(int posIn, int posOut, char[] sAsArray) {
        int res = 0;
        while(posIn>=0 && posOut<sAsArray.length) {
            if(sAsArray[posIn] == sAsArray[posOut]) {
                res++;
                posIn--; posOut++;
            }
            else break;
        }
        return res;
    }

}
