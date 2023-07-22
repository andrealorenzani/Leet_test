package name.lorenzani.andrea.hackajob.longest_subsequence;

public class Solution {

    public static int run(int[] sequence) {
        return subseq(sequence[0], 0, sequence);
    }

    private static int subseq(int val, int idx, int[] seq) {
        if(idx+1>=seq.length) return 1;
        int small = -1;
        int big = -1;
        if(val == seq[idx+1]) return 1+subseq(val, idx+1, seq);
        else if(val > seq[idx+1]){
            small = subseq(seq[idx+1], idx+1, seq);
            big = subseq(val, idx+1, seq);
        }
        else {
            big = 1+subseq(seq[idx+1], idx+1, seq);
            small = subseq(val, idx+1, seq);
        }
        return Math.max(big, small);
    }

}
