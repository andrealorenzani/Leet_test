package name.lorenzani.andrea.leet.metaprep._20250516.shortpathbinarymatrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public void printMatrix(int[][] grid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length==0 || grid[0].length==0 || grid[0][0]!=0) return -1;
        int[][] visited = new int[grid.length][grid[0].length];
        LinkedList<int[]> tbv = new LinkedList<>();
        tbv.add(new int[]{0,0});
        visited[0][0] = 1;
        while(tbv.size()>0){
            int[] visiting = tbv.pollFirst();
            int val = visited[visiting[0]][visiting[1]]+1;
            for(int i: List.of(-1, 0, 1)){
                int x = visiting[0]+i;
                if(x<0 || x>= grid.length) continue;
                for(int j: List.of(-1,0,1)){
                    if(i==0 && j==0) continue;
                    int y = visiting[1]+j;
                    if(y<0 || y>= grid[0].length) continue;
                    if(grid[x][y]==0 && (visited[x][y]<1 || visited[x][y]>val)){
                        visited[x][y] = val;
                        tbv.addLast(new int[]{x,y});
                    }
                }
            }
        }
        printMatrix(visited);
        if(visited[grid.length-1][grid[0].length-1]==0) return -1;
        return visited[grid.length-1][grid[0].length-1];
    }
}
