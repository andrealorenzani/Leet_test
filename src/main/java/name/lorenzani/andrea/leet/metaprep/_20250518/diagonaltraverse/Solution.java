package name.lorenzani.andrea.leet.metaprep._20250518.diagonaltraverse;

public class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int[] result = new int[mat.length*mat[0].length];
        // 0,0  1,0  0,1  0,2  1,1  2,0  2,1  1,2  2,2
        boolean ascending = true;
        int x=0, y=0;
        result[0] = mat[0][0];
        int posArray = 1;
        while(y!=mat.length-1 || x!=mat[0].length-1) {
            if(ascending) {
                y = y-1; x = x+1;
            }
            else {
                y = y+1; x= x-1;
            }
            if(ascending &&  (y < 0 || x > mat[0].length-1)){
                ascending=false;
                x = x+1;
                while(x > mat[0].length-1 || y < 0){
                    y = y+1; x= x-1;
                }
            }
            else if(!ascending && (y>mat.length-1 || x < 0)){
                ascending=true;
                x = x+1;
                while(y > mat.length-1 || x < 0){
                    y = y-1; x= x+1;
                }
            }
            result[posArray++] = mat[y][x];
        }
        return result;
    }
}