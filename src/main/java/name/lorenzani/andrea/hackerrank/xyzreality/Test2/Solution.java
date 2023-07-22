package name.lorenzani.andrea.hackerrank.xyzreality.Test2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Result {

    public void main(String[] args) {
        System.out.println(gainMaxValue(List.of(3,5,-2,-4,9,16), 2));
    }

    public static int gainMaxValue(List<Integer> security_val, int k) {
        // Write your code here
        int[] secValues = new int[k];
        int pointer = 0;
        for(Integer nodeValue: security_val){
            for(int i=0; i<k; i++) {
                if(pointer-i>=0 && (pointer-i)%k==0){
                    if(secValues[i]<0) secValues[i] = nodeValue;
                    else secValues[i] += nodeValue;
                }
            }
            pointer = pointer + 1;
        }
        Arrays.sort(secValues);
        return secValues[k-1];
    }

}
