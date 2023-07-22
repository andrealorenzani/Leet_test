package name.lorenzani.andrea.leet.leet_2223;

class Solution {

    public static long sumScores(String s) {
        char[] schars = s.toCharArray();
        long tot = schars.length;
        for(int i = 1; i<schars.length; i++) {
            tot += computeScoreOld(schars, schars.length - 1 - i);
        }
        return tot;
    }
    public static long sumScoresOld(String s) {
        char[] schars = s.toCharArray();
        long tot = 0;
        for(int i = 0; i<schars.length; i++) {
            tot += computeScoreOld(schars, schars.length - 1 - i);
        }
        return tot;
    }

    private static long computeScoreOld(char[] value, int pos) {
        int res = 0;
        for(; pos < value.length; pos++) {
            if(value[res] == value[pos]) res++;
            else return res;
        }
        return res;
    }
}
