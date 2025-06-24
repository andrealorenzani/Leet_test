package name.lorenzani.andrea.leet.metaprep._20250527.validnumber;

public class Solution {
    public boolean isNumber(String s) {
        int expPos = -1;
        int decimalPos = -1;
        boolean res = false;
        for(int i=0; i<s.length(); i++) {
            char val = s.charAt(i);
            switch(val){
                case '-', '+' -> {
                    if(i!=0 && i != expPos+1) return false;
                    res = false;
                }
                case 'e', 'E' -> {
                    if(expPos>-1||!res) return false;
                    expPos = i;
                    res = false;
                }
                case '.' -> {
                    if(expPos>-1) return false;
                    if(decimalPos>-1) return false;
                    decimalPos = i;
                    res = i>0&&Character.isDigit(s.charAt(i-1));
                }
                default -> {
                    if(!Character.isDigit(val)) return false;
                    res = true;
                }
            }
        }
        return res;
    }
}