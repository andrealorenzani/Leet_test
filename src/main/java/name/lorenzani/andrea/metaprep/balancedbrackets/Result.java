package name.lorenzani.andrea.metaprep.balancedbrackets;

import java.util.Scanner;
import java.util.Stack;

class Result {

    Scanner scan = new Scanner(System.in);

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        Stack<Character> balanced = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char par = s.charAt(i);
            if(par == '{' || par == '[' || par == '(') {
                balanced.push(par);
                continue;
            }
            if(balanced.isEmpty()) return "NO";
            char expected = balanced.pop();
            switch(par){
                case '}':
                    if(expected != '{') return "NO";
                    break;
                case ')':
                    if(expected != '(') return "NO";
                    break;
                case ']':
                    if(expected != '[') return "NO";
                    break;
            }
        }
        return balanced.isEmpty()? "YES" : "NO";

    }

}
