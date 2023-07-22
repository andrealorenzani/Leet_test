package name.lorenzani.andrea.codility.heliosx.july2022;

public class Solution2 {

    private static final char CLEANED = 'C';
    private static final char DIRTY = '.';
    private static final char BLOCKED = 'X';

    public int solution(String[] R) {
        char[][] grid = new char[R.length][R[0].length()];
        for(int i=0; i<R.length; i++) {
            grid[i] = R[i].toCharArray();
        }
        int result = 1;
        clean(grid, 0, 0);
        int[] pos = {0, 0};
        int[] dir = {1, 0};
        int[] nextPos = choseNextPos(grid, pos, dir);
        while(nextPos != pos){
            if(grid[nextPos[1]][nextPos[0]] == DIRTY) {
                clean(grid, nextPos[0], nextPos[1]);
                result++;
            }
            else if(grid[nextPos[1]][nextPos[0]] == CLEANED) {
                if(isInLoop(grid, pos, dir)) break;
            }
            pos = nextPos;
            nextPos = choseNextPos(grid, pos, dir);
        }
        return result;
    }

    private boolean isInLoop(char[][] grid, int[] pos, int[] dir) {
        return false; //not sure what it was doing
    }

    private int[] choseNextPos(char[][] grid, int[] pos, int[] dir){
        for(int i=0; i<4; i++){
            int[] nextPos = {pos[0]+dir[0],pos[1]+dir[1]};
            if(grid[nextPos[1]][nextPos[0]] == DIRTY) {
                return nextPos;
            }
            if(grid[nextPos[1]][nextPos[0]] == CLEANED) {
                return resolveLoop(grid, pos, dir);
            }
            else if(grid[nextPos[1]][nextPos[0]] == BLOCKED) {
                dir = turn(dir);
            }
        }
        return pos;
    }

    private int[] resolveLoop(char[][] grid, int[] pos, int[] dir) {
        return null; // not sure what it was doing
    }

    private void clean(char[][] grid, int x, int y) {
        grid[y][x] = CLEANED;
    }

    private int[] turn(int[] dir) {
        if(dir[0] == 1 && dir[1] == 0)  return new int[] {0, -1}; // right to down
        else if(dir[0] == 0 && dir[1] == -1)  return new int[] {-1, 0}; // down to left
        else if(dir[0] == -1 && dir[1] == 0)  return new int[] {0, 1}; // left to up
        else  return new int[] {1, 0}; // up to right
    }


}
