package name.lorenzani.andrea.codility.heliosx.july2022;

import java.util.HashMap;

/***
 * import java.util.*;
 *
 * class Solution {
 *     int solution(int[] A) {
 *         int N = A.length;
 *         int result = 0;
 *         for (int i = 0; i < N; i++)
 *             for (int j = 0; j < N; j++)
 *                 if (A[i] == A[j])
 *                     result = Math.max(result, Math.abs(i - j));
 *         return result;
 *     }
 * }
 */


public class Solution1 {
    int solution(int[] A) {
        int N = A.length;
        Integer[] first_occ = new Integer[N];
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (first_occ[A[i]] != null) {
                result = Math.max(result, Math.abs(i - first_occ[A[i]]));
            }
            else first_occ[A[i]] = i;
        }
        return result;
    }
}
