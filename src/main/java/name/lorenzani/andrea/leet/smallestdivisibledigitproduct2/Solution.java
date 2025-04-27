package name.lorenzani.andrea.leet.smallestdivisibledigitproduct2;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String smallestNumber(String num, long t) {
        int[] divisor = new int[9];
        int numDigits = canBeDivisible(t, divisor);
        if(numDigits == -1) return "-1";
        int[] curr = Arrays.copyOf(divisor, divisor.length);

        char[] newNum = new char[Math.max(num.length(), numDigits)];
        char[] numC = num.toCharArray();
        int lastPos = -1;
        for(int i=0; i<numC.length-numDigits; i++) {
            if(numC[i]=='0'){
                String prefix = num.substring(0, i) + '1';
                if(numDigits > numC.length - i) {
                    prefix = prefix + ('1' * (numC.length-i-numDigits));
                }
            }
            if(curr[numC[i]-'1']>0) {
                numDigits--;
            }
            else {
                lastPos = i;
            }
            curr[numC[i]-'1']--;
            newNum[i] = numC[i];
        }
        int pos=newNum.length-1;
        for(int i= curr.length-1; i >=0; i--) {
            while(curr[i]>0) {
                newNum[pos] = Character.forDigit(i+1, 10);
                curr[i]--;
                pos--;
            }
        }
        while(Long.parseLong(new String(newNum))<Long.parseLong(num)) {
            if(lastPos==-1){
                char[] tmp = new char[newNum.length+1];
                tmp[0]='1';
                for(int i=0; i< newNum.length; i++) {
                    tmp[i+1] = newNum[i];
                }
                newNum = tmp;
            }
            if(curr[newNum[lastPos]-'1']<0){
                if (newNum[lastPos] == '9') {
                    newNum[lastPos]='1';
                    lastPos--;
                }
                else {
                    newNum[lastPos]++;
                    if(curr[newNum[lastPos]-'1']==0){
                        for(int i = newNum.length-numDigits; i< newNum.length; i++){
                            if(newNum[i] == newNum[lastPos]){
                                newNum[i] = '1';
                                break;
                            }
                        }
                    }
                }
            }
            lastPos--;
        }
        return new String(newNum);
    }

    public int canBeDivisible(long t, int[] divisor){
        long remain = t;
        int numDigits = 0;
        for(int i=9; i>1; i--) {
            while(remain % i == 0) {
                remain = remain / i;
                divisor[i-1]++;
                numDigits++;
            }
        }
        if(remain > 1) return -1;
        return numDigits;
    }
}
