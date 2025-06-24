package name.lorenzani.andrea.leet.metaprep._20250520.groupshiftedstrings;

import java.util.*;

public class Solution {

    public List<List<String>> groupStrings(String[] strings) {
        HashMap<Integer, ArrayList<String>> lengthToStrings = new HashMap<>();
        for(String val : strings) {
            lengthToStrings.putIfAbsent(val.length(), new ArrayList<>());
            lengthToStrings.get(val.length()).add(val);
        }
        List<List<String>> result = new ArrayList<>();
        for(ArrayList<String> vals : lengthToStrings.values()) {
            HashSet<String> visited = new HashSet<>();
            for(int i=0; i< vals.size(); i++) {
                String val = vals.get(i);
                if(visited.contains(val)) continue;
                ArrayList<String> shift = new ArrayList<>();
                result.add(shift);
                shift.add(val);
                for(int j=i+1; j< vals.size(); j++) {
                    if(sameShift(val, vals.get(j))) {
                        shift.add(vals.get(j));
                        visited.add(vals.get(j));
                    }
                }
            }
        }

        return result;
    }

    boolean sameShift(String a, String b) {
        int alphabet = 'z'-('a'-1);
        if(a==null && b==null) return true;
        if(a.length()!=b.length()) return false;
        if(a.length()==1) return true;

        int diff = (a.charAt(0) - b.charAt(0) + alphabet) % alphabet;
        for(int i=1; i<a.length(); i++){
            if(diff != ((a.charAt(i) - b.charAt(i) + alphabet) % alphabet)) return false;
        }
        return true;
    }

}
