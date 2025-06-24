package name.lorenzani.andrea.leet.metaprep._20250516.basiccalculator2;

import java.util.LinkedList;

class Solution {
    public int calculate(String s) {
        int result = 0;
        String[] adds = s.split("\\+");
        for(String add: adds) {
            String[] subs = add.strip().split("-");
            int resultSub = 0;
            for(int i=0; i<subs.length; i++){
                if(subs[i].isEmpty()) continue;
                if(i==0) resultSub = calculateMulDiv(subs[i].strip());
                else resultSub = resultSub - calculateMulDiv(subs[i].strip());
            }
            result += resultSub;
        }
        return result;
    }

    public int calculateMulDiv(String s){
        int result = 1;
        String[] muls = s.split("\\*");
        for(String mul : muls){
            String[] divs = mul.strip().split("/");
            int resultDiv = 0;
            for(int i=0; i<divs.length; i++){
                if(i==0) result = result * Integer.parseInt(divs[i].strip());
                else result = result / Integer.parseInt(divs[i].strip());
            }
        }
        return result;
    }
}


