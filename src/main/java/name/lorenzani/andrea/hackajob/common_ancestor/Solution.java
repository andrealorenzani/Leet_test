package name.lorenzani.andrea.hackajob.common_ancestor;

public class Solution {

    private static final int[] levels = new int[20];

    public static int run(int index1, int index2) {
        return findCommonParent(index1/2, index2/2);
    }

    private static int findCommonParent(int index1, int index2) {
        if(index1 == index2) return index1;
        else if(index1 > index2) return findCommonParent(index1/2, index2);
        else return findCommonParent(index2/2, index1);
    }
}
