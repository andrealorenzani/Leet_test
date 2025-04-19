package name.lorenzani.andrea.hackerrank.sainsburys.Test2;

import java.util.HashMap;

public class Solution {

    private static HashMap<Integer, Integer> dynamicProgramming = new HashMap<>();

    public static int run(int input) {
        for(int i = 1; i<input; i++) function(i);
        int result = function(input);
        return result;
    }

    static int function(int input){
        if(input == 1) return 1;
        if(dynamicProgramming.containsKey(input)){
            return dynamicProgramming.get(input);
        }
        int tmp = function(input-1);
        int value = 1+function(input - function(tmp));
        dynamicProgramming.put(input, value);
        return value;
    }
}
