package name.lorenzani.andrea.hackerrank.deliveroo.comparethetriplets;

import java.util.ArrayList;
import java.util.List;

public class Result {
    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> result = new ArrayList<>(List.of(0,0));
        for(int i=0; i<3; i++) {
            if(a.get(i)>b.get(i)) result.set(0, result.get(0)+1);
            if(a.get(i)<b.get(i)) result.set(1, result.get(1)+1);;
        }
        return result;
    }
}
