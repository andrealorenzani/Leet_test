package name.lorenzani.andrea.hackajob.find_singleton;

public class Solution {

    public static int run(int[] student_list) {
        /*
         * Write your code below; return type and arguments should be according to the problem's requirements
         */
        int[] marker = new int[100000];
        for (int j : student_list) {
            marker[j] = (marker[j] + 1) % 2;
        }
        for(int j=0; j< marker.length; j++) {
            if(marker[j] == 1) return j;
        }
        return 0;
    }
}