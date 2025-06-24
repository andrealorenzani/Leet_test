package name.lorenzani.andrea.leet.metaprep._20250520.makingalargeisland;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {
    int[][] visited;
    HashMap<Integer, Integer> mapToSize;

    public int largestIsland(int[][] grid) {
        visited = new int[grid.length][grid[0].length];
        mapToSize = new HashMap<>();
        int max = -1;
        for(int y=0; y<grid.length; y++) {
            for(int x=0; x<grid[0].length; x++) {
                if(visited[y][x]>0) continue;
                else {
                    if(grid[y][x]==1) {
                        checkIsland(grid, x, y);
                    }
                }
            }
        }
        if(mapToSize.size()==1) return Math.min(mapToSize.get(1) + 1, grid.length*grid[0].length);
        for(int y=0; y<grid.length; y++) {
            for(int x=0; x<grid[0].length; x++) {
                if(grid[y][x]==0) {
                    max = Math.max(max, connectIslands(visited, x, y));
                }
            }
        }
        return Math.max(max, 1);
    }

    public void checkIsland(int[][] grid, int x, int y) {
        LinkedList<Map.Entry<Integer, Integer>> tbv = new LinkedList<>();
        if(grid[y][x] == 0) return;
        if(grid[y][x] == 1 && visited[y][x]>0) return;

        tbv.push(Map.entry(x, y));
        int islandSize = 0;
        int islandName = mapToSize.size()+1;
        while(!tbv.isEmpty()) {
            Map.Entry<Integer, Integer> visiting = tbv.pollFirst();
            int vx = visiting.getKey();
            int vy = visiting.getValue();
            if(visited[vy][vx]>0) continue;
            else visited[vy][vx] = islandName;
            islandSize++;

            if(vy-1>=0 && grid[vy-1][vx]==1) tbv.addLast(Map.entry(vx, vy-1));
            if(vx-1>=0 && grid[vy][vx-1]==1) tbv.addLast(Map.entry(vx-1, vy));
            if(vy+1<grid.length && grid[vy+1][vx]==1) tbv.addLast(Map.entry(vx, vy+1));
            if(vx+1<grid[0].length && grid[vy][vx+1]==1) tbv.addLast(Map.entry(vx+1, vy));
        }

        mapToSize.put(islandName, islandSize);
    }

    public int connectIslands(int[][] grid, int x, int y) {
        HashMap<Integer, Integer> connected = new HashMap<>();
        if(y-1>=0 && visited[y-1][x]>=1)
            connected.put(visited[y-1][x], mapToSize.getOrDefault(visited[y-1][x], 0));
        if(x-1>=0 && visited[y][x-1]>=1)
            connected.put(visited[y][x-1], mapToSize.getOrDefault(visited[y][x-1], 0));
        if(y+1<grid.length && visited[y+1][x]>=1)
            connected.put(visited[y+1][x], mapToSize.getOrDefault(visited[y+1][x], 0));
        if(x+1<grid[0].length && visited[y][x+1]>=1)
            connected.put(visited[y][x+1], mapToSize.getOrDefault(visited[y][x+1], 0));

        return connected.values().stream().mapToInt(i -> i).sum()+1;
    }

    /*boolean[][] visited;
    public int largestIslandAlmost(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int max = -1;
        for(int y=0; y<grid.length; y++) {
            for(int x=0; x<grid[0].length; x++) {
                if(visited[y][x]) continue;
                else {
                    if(grid[y][x]==1) {
                        int[] maxIsland = makeIsland(grid, x, y);
                        max = Math.max(max, maxIsland[1]);
                    }
                }
            }
        }
        return Math.max(max, 1);
    }


    private int[] makeIsland(int[][] grid, int x, int y) {
        LinkedList<Map.Entry<Integer, Integer>> tbv = new LinkedList<>();
        LinkedList<Map.Entry<Integer, Integer>> toBeConverted = new LinkedList<>();
        int islandSize = 0;
        if(grid[y][x] == 0) return new int[] {-1, -1};
        if(grid[y][x] == 1 && visited[y][x]) return new int[] {-1, -1};

        tbv.push(Map.entry(x, y));
        while(!tbv.isEmpty()) {
            Map.Entry<Integer, Integer> visiting = tbv.pollFirst();
            int vx = visiting.getKey();
            int vy = visiting.getValue();
            if(visited[vy][vx]) continue;
            else visited[vy][vx] = true;
            islandSize++;

            if(vy-1>=0 && grid[vy-1][vx]==1) tbv.addLast(Map.entry(vx, vy-1));
            else if(vy-1>=0 && grid[vy-1][vx]==0) toBeConverted.addLast(Map.entry(vx, vy-1));

            if(vx-1>=0 && grid[vy][vx-1]==1) tbv.addLast(Map.entry(vx-1, vy));
            else if(vx-1>=0 && grid[vy][vx-1]==0) toBeConverted.addLast(Map.entry(vx-1, vy));

            if(vy+1<grid.length && grid[vy+1][vx]==1) tbv.addLast(Map.entry(vx, vy+1));
            else if(vy+1<grid.length && grid[vy+1][vx]==0) toBeConverted.addLast(Map.entry(vx, vy+1));

            if(vx+1<grid[0].length && grid[vy][vx+1]==1) tbv.addLast(Map.entry(vx+1, vy));
            else if(vx+1<grid[0].length && grid[vy][vx+1]==0) toBeConverted.addLast(Map.entry(vx+1, vy));
        }
        int maxSize = islandSize + ((toBeConverted.size()>0)?1:0);
        while(!toBeConverted.isEmpty()) {
            Map.Entry<Integer, Integer> visiting = toBeConverted.pollFirst();
            int vx = visiting.getKey();
            int vy = visiting.getValue();
            int[] maxMax;
            if(vy-1>0 && grid[vy-1][vx]==1 && !visited[vy-1][vx]) {
                maxMax = makeIsland(grid, vx, vy-1);
                maxSize =  Math.max(maxSize, islandSize++maxMax[0]);
                maxSize = Math.max(maxSize, maxMax[1]);
            }
            if(vx-1>0 && grid[vy][vx-1]==1 && !visited[vy][vx-1]) {
                maxMax = makeIsland(grid, vx-1, vy);
                maxSize =  Math.max(maxSize, islandSize+1+maxMax[0]);
                maxSize = Math.max(maxSize, maxMax[1]);
            }
            if(vy+1<grid.length && grid[vy+1][vx]==1 && !visited[vy+1][vx]) {
                maxMax = makeIsland(grid, vx, vy+1);
                maxSize =  Math.max(maxSize, islandSize+1+maxMax[0]);
                maxSize = Math.max(maxSize, maxMax[1]);
            }
            if(vx+1<grid[0].length && grid[vy][vx+1]==1 && !visited[vy][vx+1]) {
                maxMax = makeIsland(grid, vx+1, vy);
                maxSize =  Math.max(maxSize, islandSize+1+maxMax[0]);
                maxSize = Math.max(maxSize, maxMax[1]);
            }
        }

        return new int[]{islandSize, maxSize};
    }*/

}
