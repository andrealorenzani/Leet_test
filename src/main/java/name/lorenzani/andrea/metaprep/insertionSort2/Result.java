package name.lorenzani.andrea.metaprep.insertionSort2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'insertionSort2' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static void insertionSort2(int n, List<Integer> arr) {
        // Write your code here
        for(int i=1; i<n; i++) {
            int pivot = arr.get(i);
            for(int j=0; j<=i; j++) {
                if(arr.get(j)>pivot) {
                    int tmp = arr.get(j);
                    arr.set(j, pivot);
                    pivot = tmp;
                }
            }
            arr.set(i, pivot);
            System.out.println(arr.stream()
                    .map(String::valueOf).collect(Collectors.joining(" ")));

        }

    }

}
