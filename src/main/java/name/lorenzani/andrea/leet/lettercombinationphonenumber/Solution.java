package name.lorenzani.andrea.leet.lettercombinationphonenumber;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    Map<Character, List<String>> phoneMap;

    public List<String> letterCombinations(String digits) {
        initPhoneMap();
        return letterCombinations(digits, 0);
    }

    public void initPhoneMap() {
        phoneMap = Map.ofEntries(
                Map.entry('1', List.of(" ")),
                Map.entry('2', List.of("a", "b", "c")),
                Map.entry('3', List.of("d", "e", "f")),
                Map.entry('4', List.of("g", "h", "i")),
                Map.entry('5', List.of("j", "k", "l")),
                Map.entry('6', List.of("m", "n", "o")),
                Map.entry('7', List.of("p", "q",  "r", "s")),
                Map.entry('8', List.of("t", "u", "v")),
                Map.entry('9', List.of("w", "x", "y", "z")));
    }

    public List<String> letterCombinations(String digits, int pos) {
        if(pos >= digits.length()) return new LinkedList<>();
        if(digits.length()-pos == 1) return phoneMap.get(digits.charAt(pos));
        char thisDigit = digits.charAt(pos);
        List<String> recurr = letterCombinations(digits, pos+1);
        return phoneMap.get(thisDigit).stream()
                .flatMap(value -> recurr.stream()
                                        .map(rval -> value+rval))
                .collect(Collectors.toList());
    }
}
