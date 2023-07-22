package name.lorenzani.andrea.leet.leet_8;

import java.util.Arrays;

public class Solution {

    // Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
    // Memory Usage: 42.5 MB, less than 78.99% of Java online submissions for String to Integer (atoi).
    public static int myAtoi(String s) {
        int result = 0;
        char sign = ' ';
        for(char c: s.toCharArray()) {
            int prevVal = result;
            switch(c) {
                case '+':
                case '-':
                    if(sign == ' ' && result == 0) {
                        sign = c;
                        break;
                    }
                    else {
                        return (sign == '-') ? result * (-1) : result;
                    }
                case '1':
                    result = result * 10 + 1; break;
                case '2':
                    result = result * 10 + 2; break;
                case '3':
                    result = result * 10 + 3; break;
                case '4':
                    result = result * 10 + 4; break;
                case '5':
                    result = result * 10 + 5; break;
                case '6':
                    result = result * 10 + 6; break;
                case '7':
                    result = result * 10 + 7; break;
                case '8':
                    result = result * 10 + 8; break;
                case '9':
                    result = result * 10 + 9; break;
                case '0':
                    if(sign == ' ') sign = '0';
                    result = result * 10; break;
                case ' ':
                    if(sign == ' ' && result == 0) break;
                default:
                    return (sign == '-')? result * (-1): result;
            }
            if(result < 0 || prevVal > result || prevVal > Integer.MAX_VALUE/10){
                return (sign == '-')? Integer.MIN_VALUE: Integer.MAX_VALUE;
            }
        }
        return (sign == '-')? result * (-1): result;}
}