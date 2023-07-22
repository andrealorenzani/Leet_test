package name.lorenzani.andrea.codility.heliosx.july2022;

import java.util.HashSet;

public class TestTask {

    public int solution(int[] A) {
        HashSet<Integer> m = new HashSet<>();
        for(int i: A) {
            m.add(i);
        }
        for(int i=1; i<=100000; i++) {
            if(!m.contains(i)){
                return i;
            }
        }
        return -1;
    }
}
