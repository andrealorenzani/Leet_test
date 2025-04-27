package name.lorenzani.andrea.metaprep.AVeryBigSum;

import java.util.List;

class Result {

    /*
     * Complete the 'aVeryBigSum' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY ar as parameter.
     */

    public static long aVeryBigSum(List<Long> ar) {

        long numOfInt = ar.get(0);
        long res = 0;
        for(long i: ar) {
            res += i;
        }
        return res;

    }

}
