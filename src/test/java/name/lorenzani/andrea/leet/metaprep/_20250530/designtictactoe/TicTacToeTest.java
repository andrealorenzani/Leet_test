package name.lorenzani.andrea.leet.metaprep._20250530.designtictactoe;

import junit.framework.TestCase;
import org.junit.Assert;

public class TicTacToeTest extends TestCase {

    public void testBasic1() {
        TicTacToe sol = new TicTacToe(3);

        play(sol, new int[][]{{0,0,1},{0,2,2},{2,2,1},{1,1,2},{2,0,1},{1,0,2},{2,1,1}}, new int[] {0, 0, 0, 0, 0, 0, 1});
    }

    public void testFailing1() {
        TicTacToe sol = new TicTacToe(2);

        play(sol, new int[][]{{0,1,1},{1,1,2},{1,0,1}}, new int[] {0, 0, 1});
    }

    public void testFailing2() {
        TicTacToe sol = new TicTacToe(2);

        play(sol, new int[][]{{0,1,2},{1,0,1},{1,1,2}}, new int[] {0, 0, 2});
    }

    private void play(TicTacToe sol, int[][] moves, int[] expected) {
        int[] actual = new int[moves.length];
        int pos = 0;
        for(int[] move : moves) {
            actual[pos++] = sol.move(move[0], move[1], move[2]);
        }
        Assert.assertArrayEquals(expected, actual);
    }

}