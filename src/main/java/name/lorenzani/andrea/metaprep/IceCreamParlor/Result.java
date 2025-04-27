package name.lorenzani.andrea.metaprep.IceCreamParlor;

import java.util.HashMap;
import java.util.List;

public class Result {

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here 5, 1 4 5 3 2
        HashMap<Integer, Integer> values = new HashMap<>();
        for(int i=0; i<arr.size(); i++) {
            values.put(arr.get(i), i+1);
        }
        for(int i=0; i<arr.size(); i++) {
            Integer found = values.get(m-arr.get(i));
            if(found!=null) {
                return List.of(i+1, found);
            }
        }
        return List.of();
    }

}
