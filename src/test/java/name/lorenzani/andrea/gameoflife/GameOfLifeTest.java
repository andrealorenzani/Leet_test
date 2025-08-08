package name.lorenzani.andrea.gameoflife;

import junit.framework.TestCase;
import name.lorenzani.andrea.ohme.gameoflife.GameOfLife;

public class GameOfLifeTest extends TestCase {

    public void testBlinker() {
        boolean[][] blink = new boolean[][]{{false, false, false, false, false},
                {false, false, false, false, false},
                {false, true, true, true, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};
        GameOfLife ut = new GameOfLife(blink);
        ut.makeATick();
        ut.makeATick();
        ut.makeATick();
        assertEquals(1,1);
    }


    public void testBlinkerEdge() {
        boolean[][] blink = new boolean[][]{
                {true, true, true, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false},
                {false, false, false, false, false}};
        GameOfLife ut = new GameOfLife(blink);
        /*ut.makeATick();
        ut.makeATick();
        ut.makeATick();*/
        ut.run();
        assertEquals(1,1);
    }

}