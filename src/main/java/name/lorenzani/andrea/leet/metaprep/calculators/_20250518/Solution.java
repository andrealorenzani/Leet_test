package name.lorenzani.andrea.leet.metaprep.calculators._20250518;

import java.util.List;
import java.util.Stack;

public class Solution {

    List<Character> operands = List.of('+', '-', '/', '*', '(', ')');

    public int calculate(String s) {
        return calculate(s, 0)[0];
    }


    // 89 + 24 (15 / 9 + 3) + 12
    // 23 - 12 + 4 * 3

    protected int[] calculate(String s, int start) {
        int total = 0;
        int currVal = 0;
        int prevVal = 0;
        char operand = '+';
        char lastChar = '+';
        for(int i=start; i<s.length(); i++) {
            char val = s.charAt(i);
            if(Character.isSpaceChar(val)) continue;
            if(Character.isDigit(val)) {
                currVal = currVal*10 + (val - '0');
                lastChar = val;
                continue;
            }
            if(val==')') {
                if(operand == '+') total = total+prevVal+currVal;
                if(operand == '-') total = total+prevVal-currVal;
                if(operand == '*') total = total+prevVal*currVal;
                if(operand == '/') total = total+prevVal/currVal;
                return new int[]{total, i};
            }
            if(val=='(') {
                int[] res = calculate(s, i+1);
                currVal = res[0];
                if(Character.isDigit(lastChar)) operand = '*';
                i = res[1];
                continue;
            }
            if(operands.contains(val) || i==s.length()-1) {
                switch(operand) {
                    case '+' -> {
                        total += prevVal;
                        prevVal = currVal;
                        currVal = 0;
                    }
                    case '-' -> {
                        total += prevVal;
                        prevVal = -currVal;
                        currVal = 0;
                    }
                    case '*' -> {
                        prevVal = prevVal*currVal;
                        currVal = 0;
                    }
                    case '/' -> {
                        prevVal = prevVal/currVal;
                        currVal = 0;
                    }
                }
            }

            operand =  val;
            lastChar = val;
        }
        if(operand == '+') total = total+prevVal+currVal;
        if(operand == '-') total = total+prevVal-currVal;
        if(operand == '*') total = total+prevVal*currVal;
        if(operand == '/') total = total+prevVal/currVal;
        return new int[]{total, -1};
    }
}
