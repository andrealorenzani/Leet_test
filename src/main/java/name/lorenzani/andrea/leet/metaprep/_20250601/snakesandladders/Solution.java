package name.lorenzani.andrea.leet.metaprep._20250601.snakesandladders;

import java.util.ArrayList;

public class Solution {

    public int snakesAndLadders(int[][] board) {

        int[][] visited = new int[board.length][board[0].length];
        visited[board.length-1][0] = 1;
        int res = visit(board, visited, 0, 0);
        return res;

    }

    public int visit(int[][] board, int[][] visited, int pos, int dices) {
        int boardSize = board.length * board[0].length;
        if(pos == boardSize-1) return dices;
        if(pos > boardSize-7) return dices+1;
        int lastNormalPos = pos;
        ArrayList<Integer> possibleRes = new ArrayList<>();
        for(int nextPos=pos+1; nextPos<=pos+6; nextPos++) {
            int[] coord = postToCoordinates(nextPos, board.length);
            if(visited[coord[0]][coord[1]]>0 && visited[coord[0]][coord[1]]<dices+1) continue;
            visited[coord[0]][coord[1]] = dices+1;
            if(board[coord[0]][coord[1]]!=-1){
                int[] newCoord = postToCoordinates(board[coord[0]][coord[1]]-1, board.length);
                if(visited[newCoord[0]][newCoord[1]]>0 && visited[newCoord[0]][newCoord[1]]<dices+1) {
                    continue;
                }
                possibleRes.add(visit(board, visited, board[coord[0]][coord[1]]-1, dices+1));
            }
            else lastNormalPos = nextPos;
        }
        if(lastNormalPos != pos) possibleRes.add(visit(board, visited, lastNormalPos, dices+1));
        return possibleRes.stream().filter(x -> x!=-1).mapToInt(i -> i).min().orElse(-1);
    }

    int[] postToCoordinates(int pos, int n) {
        int y = n - 1 - (pos / n);
        int x = (y%2==(n-1)%2)?pos%n:n-1-(pos%n);
        return new int[] {y, x};
    }
}
