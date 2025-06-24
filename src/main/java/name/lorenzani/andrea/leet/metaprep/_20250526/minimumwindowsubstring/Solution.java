package name.lorenzani.andrea.leet.metaprep._20250526.minimumwindowsubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> requiredOcc = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char val = t.charAt(i);
            requiredOcc.putIfAbsent(val, 0);
            requiredOcc.put(val, requiredOcc.get(val) + 1);
        }
        int solStart=0; int solEnd = s.length();
        int start = 0; int end = 0;
        HashMap<Character, Integer> found = new HashMap<>();
        for(; end<s.length(); end++) {
            char val = s.charAt(end);
            if(requiredOcc.containsKey(val)){
                if(found.isEmpty()) start = end;
                found.put(val, found.getOrDefault(val, 0)+1);
                if(found.get(val) > requiredOcc.get(val)) {
                    for(;start<end;start++) {
                        char tbc = s.charAt(start);
                        if(requiredOcc.getOrDefault(tbc, 0) < found.getOrDefault(tbc, 1)) {
                            if(found.containsKey(tbc)) found.put(tbc, found.get(tbc)-1);
                        }
                        else break;
                    }
                }
                if(found.size()==requiredOcc.size() &&
                        (solEnd-solStart > end-start) &&
                        found.entrySet().stream()
                                .noneMatch(fitem -> fitem.getValue() < requiredOcc.get(fitem.getKey())))
                {
                    solStart = start;
                    solEnd = end;
                }
            }
        }
        if(found.size()< requiredOcc.size() ||
                found.entrySet().stream().anyMatch(fitem -> fitem.getValue() < requiredOcc.get(fitem.getKey())))
        {
            return "";
        }
        return s.substring(solStart, solEnd+1);
    }

    public String minWindowNotWorking(String s, String t) {
        HashMap<Character, Integer> requiredOcc = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> charPos = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            char val = t.charAt(i);
            requiredOcc.putIfAbsent(val, 0);
            requiredOcc.put(val, requiredOcc.get(val)+1);
        }
        for(int i=0; i<s.length(); i++) {
            char val = s.charAt(i);
            if(requiredOcc.containsKey(val)) {
                charPos.putIfAbsent(val, new ArrayList<>());
                charPos.get(val).add(i);
            }
        }
        if(requiredOcc.size()> charPos.size()) return "";
        ArrayList<int[]> solutions = new ArrayList<>();
        for(Map.Entry<Character, Integer> reqChar: requiredOcc.entrySet()){
            ArrayList<Integer> visitingCharPos = charPos.getOrDefault(reqChar.getKey(), new ArrayList<>());
            if(reqChar.getValue()> visitingCharPos.size()) return "";
            ArrayList<int[]> newsol = new ArrayList<>();
            if(solutions.isEmpty()) {
                for(int r=reqChar.getValue()-1; r< visitingCharPos.size(); r++) {
                    int start = visitingCharPos.get(r - (reqChar.getValue() - 1));
                    int end = visitingCharPos.get(r);
                    newsol.add(new int[]{start, end});
                }
            }
            else {
                for(int r=reqChar.getValue()-1; r< visitingCharPos.size(); r++) {
                    int start = visitingCharPos.get(r - (reqChar.getValue() - 1));
                    int end = visitingCharPos.get(r);
                    for (int i=0; i<solutions.size(); i++){
                        if(i+1 > newsol.size()) newsol.add(new int[]{Math.min(solutions.get(i)[0], start), Math.max(solutions.get(i)[1], end)});
                        else if (Math.max(solutions.get(i)[1], end)-Math.min(solutions.get(i)[0], start)<newsol.get(i)[1]-newsol.get(i)[0]) {
                            newsol.get(i)[1] = Math.max(solutions.get(i)[1], end);
                            newsol.get(i)[0] = Math.min(solutions.get(i)[0], start);
                        }
                    }
                }
            }
            solutions = newsol;
            ArrayList<int[]> newSol = new ArrayList<>();
            for (int i=0; i<solutions.size(); i++){
                boolean tbr = false;
                int[] iSol = solutions.get(i);
                for(int j=i+1; j< solutions.size(); j++) {
                    int[] jSol = solutions.get(j);
                    if(jSol[0]>iSol[1]) break;
                    if(jSol[0]>=iSol[0] && jSol[1]<=iSol[1]) tbr = true;
                }
                if(!tbr) newSol.add(iSol);
            }
            solutions = newSol;
        }
        int[] finalSol = new int[] {0, s.length()-1};
        for(int[] sol : solutions) {
            if(sol[1]-sol[0]+1 < finalSol[1]-finalSol[0]+1){
                finalSol = sol;
            }
        }
        return s.substring(finalSol[0], finalSol[1]+1);
    }

    public String minWindowTooSlow(String s, String t) {
        HashMap<Character, Integer> requiredOcc = new HashMap<>();
        HashMap<Character, ArrayList<Integer>> charPos = new HashMap<>();
        for(int i=0; i<t.length(); i++) {
            char val = t.charAt(i);
            requiredOcc.putIfAbsent(val, 0);
            requiredOcc.put(val, requiredOcc.get(val)+1);
        }
        for(int i=0; i<s.length(); i++) {
            char val = s.charAt(i);
            if(requiredOcc.containsKey(val)) {
                charPos.putIfAbsent(val, new ArrayList<>());
                charPos.get(val).add(i);
            }
        }
        if(requiredOcc.size()> charPos.size()) return "";
        ArrayList<int[]> solutions = new ArrayList<>();
        for(Map.Entry<Character, Integer> reqChar: requiredOcc.entrySet()){
            ArrayList<Integer> visitingCharPos = charPos.getOrDefault(reqChar.getKey(), new ArrayList<>());
            if(reqChar.getValue()> visitingCharPos.size()) return "";
            boolean toBeAdded = solutions.isEmpty();
            ArrayList<int[]> newsol = new ArrayList<>();
            for(int r=reqChar.getValue()-1; r< visitingCharPos.size(); r++){
                int start = visitingCharPos.get(r-(reqChar.getValue()-1));
                int end = visitingCharPos.get(r);
                if(toBeAdded) newsol.add(new int[]{start, end});
                else {
                    for (int i=0; i<solutions.size(); i++){
                        int[] prevSol = solutions.get(i);
                        newsol.add(new int[] {Math.min(prevSol[0], start), Math.max(end, prevSol[1])});
                    }
                }
            }
            solutions = newsol;
            ArrayList<int[]> newSol = new ArrayList<>();
            for (int i=0; i<solutions.size(); i++){
                boolean tbr = false;
                int[] iSol = solutions.get(i);
                for(int j=i+1; j< solutions.size(); j++) {
                    int[] jSol = solutions.get(j);
                    if(jSol[0]>iSol[1]) break;
                    if(jSol[0]>=iSol[0] && jSol[1]<=iSol[1]) tbr = true;
                }
                if(!tbr) newSol.add(iSol);
            }
            solutions = newSol;
        }
        int[] finalSol = new int[] {0, s.length()-1};
        for(int[] sol : solutions) {
            if(sol[1]-sol[0]+1 < finalSol[1]-finalSol[0]+1){
                finalSol = sol;
            }
        }
        return s.substring(finalSol[0], finalSol[1]+1);
    }
}
