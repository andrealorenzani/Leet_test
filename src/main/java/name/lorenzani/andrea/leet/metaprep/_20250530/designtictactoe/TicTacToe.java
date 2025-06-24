package name.lorenzani.andrea.leet.metaprep._20250530.designtictactoe;

public class TicTacToe {

    //int[][] board;
    int[][] goalSituation;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        //board = new int[n][n];
        goalSituation = new int[2][n*2+2]; // 2 player, 1..n orizontali, n+1..2n verticali, 2n+1 and 2n+2 diagonal
    }

    public int move(int row, int col, int player) {
        // Set the player values
        //board[row][col] = player;
        goalSituation[player-1][row]++;
        goalSituation[player-1][n+col]++;
        if(col==row) goalSituation[player-1][2*n]++;
        if(col==n-1-row) goalSituation[player-1][2*n+1]++;
        // Invalidate the goals of the opponent
        int opponent = 2-player;
        goalSituation[opponent][row] = -n;
        goalSituation[opponent][n+col] = -n;
        if(col==row) goalSituation[opponent][2*n] = -n;
        if(col==n-1-row) goalSituation[opponent][2*n+1] = -n;
        // Check victory
        if(goalSituation[player-1][row] == n ||
                goalSituation[player-1][n+col] == n ||
                goalSituation[player-1][2*n] == n ||
                goalSituation[player-1][2*n+1] == n)
            return player;
        return 0;
    }
}
