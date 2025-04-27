package name.lorenzani.andrea.metaprep.leftRotation;

import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

    public static List<Integer> rotLeft(List<Integer> a, int d) {
        // Write your code here
        List<Integer> result = new ArrayList<>(a.size());
        for(int i=0; i<a.size(); i++){
            result.add(i, a.get((i+d)%a.size()));
        }
        return result;

    }

}

