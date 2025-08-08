package name.lorenzani.andrea.ohme.gameoflife;

import java.util.Objects;

public class GameOfLife {

    // https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

    boolean[][] grid;

    public GameOfLife(boolean[][] grid) {
        this.grid = grid;
    }

    public void run() {
        // I implemented this after the interview
        while(true) {
            makeATick();
            try {
                Thread.sleep(1000);
            } catch(Exception e) {}
        }
    }

    public void makeATick() {
        boolean[][] newGrid = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                int liveNeighbours = countLiveNeighbours(i, j);
                if(grid[i][j]) {
                    if(liveNeighbours<2) newGrid[i][j]=false;
                    if(liveNeighbours==2 || liveNeighbours==3) newGrid[i][j]=true;
                    if(liveNeighbours>3) newGrid[i][j]=false;
                }
                if(!grid[i][j] && liveNeighbours==3) {
                    newGrid[i][j] = true;
                }
            }
        }
        print(grid, newGrid);
        grid = newGrid;
    }

    public int countLiveNeighbours(int i, int j) {
        int nlive =0;
        int isize = grid.length;
        int jsize = grid[0].length;
        if(grid[(i-1+isize)%isize][(j-1+jsize)%jsize]) nlive++;
        if(grid[(i-1+isize)%isize][j]) nlive++;
        if(grid[(i-1+isize)%isize][(j+1)%jsize]) nlive++;

        if(grid[i][(j-1+jsize)%jsize]) nlive++;
        if(grid[i][(j+1)%jsize]) nlive++;

        if(grid[(i+1)%isize][(j-1+jsize)%jsize]) nlive++;
        if(grid[(i+1)%isize][j]) nlive++;
        if(grid[(i+1)%isize][(j+1)%jsize]) nlive++;

        return nlive;
    }


    public void print(boolean[][] grid, boolean[][] newgrid) {
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                System.out.print((grid[i][j]?1:0));
            }
            System.out.print("     ");
            for(int j=0; j<grid[0].length; j++) {
                System.out.print((newgrid[i][j]?1:0));
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
}
