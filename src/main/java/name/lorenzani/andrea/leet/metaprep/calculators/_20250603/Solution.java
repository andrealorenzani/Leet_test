package name.lorenzani.andrea.leet.metaprep.calculators._20250603;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        return calculate(s, 0)[0];
    }
    public int[] calculate(String s, int start) {
        LinkedList<Double> addSubs = new LinkedList<>();
        addSubs.add(0d);
        char preOp = '+';
        for(int i=start; i<s.length(); i++) {
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)) {
                addSubs.add(10*addSubs.pollLast()+(currChar-'0'));
            }
            else if(currChar == '(') {
                int[] sub = calculate(s, i+1);
                if(addSubs.getLast()==0d) addSubs.pollLast();
                addSubs.add((double)sub[0]);
                i = sub[1];
            }
            if(")+-*/".indexOf(currChar)>=0 || i == s.length()-1) {
                if(preOp == '*' || preOp == '/') {
                    double prevVal = addSubs.pollLast();
                    double val = addSubs.pollLast();
                    if(preOp == '*') addSubs.add(val*prevVal);
                    else addSubs.add(val/prevVal);
                    preOp = currChar;
                    addSubs.add(0d);
                }
                else {
                    addSubs.add(preOp=='+'?addSubs.pollLast():-addSubs.pollLast());
                    preOp = currChar;
                    addSubs.add(0d);
                }
            }
            if(currChar==')') return new int[] {addSubs.stream().mapToInt(Double::intValue).sum(), i};
        }
        return new int[] {addSubs.stream().mapToInt(Double::intValue).sum(), s.length()-1};
    }

    public int calculateWithoutParenthesis(String s, int start) {
        LinkedList<Double> addSubs = new LinkedList<>();
        double prevVal = 0;
        char preOp = '+';
        for(int i=start; i<s.length(); i++) {
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)) {
                prevVal = 10*prevVal+(currChar-'0');
            }
            else if(Character.isSpaceChar(currChar)) {
                continue;
            }
            if("+-*/".indexOf(currChar)>=0 || i == s.length()-1) {
                if(preOp == '*' || preOp == '/') {
                    double val = addSubs.pollLast();
                    if(preOp == '*') addSubs.add(val*prevVal);
                    else addSubs.add(val/prevVal);
                    preOp = currChar;
                    prevVal = 0;
                }
                else {
                    addSubs.add(preOp=='+'?prevVal:-prevVal);
                    preOp = currChar;
                    prevVal = 0;
                }
            }
        }
        return addSubs.stream().mapToInt(Double::intValue).sum();
    }
}
