package name.lorenzani.andrea.leet.metaprep._20250511.maxswap;

import java.util.*;
import java.util.function.Function;

public class Solution {

    public int maximumSwap(int num) {
        TreeMap<Integer, LinkedList<Integer>> values = new TreeMap<>(Comparator.reverseOrder());
        int numDigits = (int) Math.log10(num)+1;
        int[] digits = new int[numDigits];
        int pos = 0;
        while(num>0){
            values.putIfAbsent(num%10, new LinkedList<>());
            values.get(num%10).addFirst(pos);
            digits[pos] = num%10;
            pos++;
            num = num/10;
        }
        int maxPos = -1;
        int minPos = numDigits-1;
        for(LinkedList<Integer> positions: values.values()){
            for(Integer orderedPos : positions) {
                if (orderedPos < minPos) {
                    maxPos = orderedPos;
                    break;
                }
                minPos--;
            }
            if(maxPos>-1) {
                maxPos = positions.getLast();
                break;
            }
        }
        if(maxPos>-1) {
            int tmp = digits[maxPos];
            digits[maxPos] = digits[minPos];
            digits[minPos] = tmp;
        }

        int result =0;
        for(int i= digits.length-1;i>=0; i--){
            result = (result*10)+digits[i];
        }
        return result;
    }

    public int maximumSwapBrute(int num) {
        int[] values = new int[(int) Math.log10((double)num)+1];
        int pos = 0;
        while(num>0){
            values[pos] = num%10;
            pos++;
            num = num/10;
        }
        for(int i=values.length-1; i>=0; i--) {
            int maxPos = -1;
            for(int j=0; j<i; j++){
                if(values[j]>values[i] &&
                        (maxPos==-1 || values[maxPos]<values[j])){
                    maxPos = j;
                }
            }
            if(maxPos>-1) {
                int tmp = values[i];
                values[i] = values[maxPos];
                values[maxPos]=tmp;
                break;
            }
        }
        int result =0;
        for(int i= values.length-1;i>=0; i--){
            result = (result*10)+values[i];
        }
        return result;
    }
}
