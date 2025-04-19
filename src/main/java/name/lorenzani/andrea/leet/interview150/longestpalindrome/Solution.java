package name.lorenzani.andrea.leet.interview150.longestpalindrome;

import java.util.Stack;

/*
* # Intuition
There is not too much to optimise here: you need to check all the possible substring for palindromes. The only two things that I tried to optimise is to always start from the longest substring and stop when the length would be too short

# Approach
You write a support `isPalindrome` function (using pointers, because using Stack is a bit too much expensive).
Then you do a `for loop` for all the letters in the string. For each letter you find the last matching letter and if the length
* */

class Solution {
    public String longestPalindrome(String s) {
        int resultStart = -1;
        int resultEnd = -1;
        for(int i=0; i<s.length(); i++) {
            for(int j=s.length()-1; j>=i + (resultEnd-resultStart); j--) {
                if(s.charAt(i) == s.charAt(j) &&
                isPalindrome(s, i, j)){
                    resultStart = i;
                    resultEnd = j;
                }
            }
        }
        return s.substring(resultStart, resultEnd+1);
    }

    public boolean isPalindrome(String check, int start, int end) {
        for(int i=0; i<=(end-start)/2; i++){
            if(check.charAt(i+start)!=check.charAt(end-i)) {
                return false;
            }
        }
        return true;
        /*Stack<Character> support = new Stack<>();
        for(char c: check.toCharArray()){
            support.push(c);
        }
        for(char c: check.toCharArray()){
            if(c != support.pop()) {
                return false;
            }
        }
        return true;*/
    }

    public boolean isPalindrome(String check) {
        for(int i=0; i<=(check.length()-1)/2; i++){
            if(check.charAt(i)!=check.charAt(check.length()-1-i)) {
                return false;
            }
        }
        return true;
        /*Stack<Character> support = new Stack<>();
        for(char c: check.toCharArray()){
            support.push(c);
        }
        for(char c: check.toCharArray()){
            if(c != support.pop()) {
                return false;
            }
        }
        return true;*/
    }
}
