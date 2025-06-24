package name.lorenzani.andrea.leet.metaprep._20250531.robotroomcleaner;

import java.util.Stack;

interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}

public class Solution {
    int[][] maxGrid;

    public void cleanRoom(Robot robot) {
        maxGrid = new int[201][401];
        maxGrid[100][100] = 1;
        int x = 100;
        int y = 100;

        move(new int[]{100, 100}, 0, robot);

    }

    public void move(int[] pos, int facing, Robot robot) {
        // clean
        robot.clean();
        // set as visited
        maxGrid[pos[1]][pos[0]] = 1;
        int currFacing = facing;
        // move right if it is not going back
        if(maxGrid[pos[1]][pos[0]+1] == 0 && facing != 3) {
            turn(currFacing, 1, robot);
            currFacing = 1;
            if(robot.move()) {
                move(new int[]{pos[1], pos[0]+1}, 1, robot);
                currFacing = 3;
            }
        }
        // move left if it is not going back
        if(maxGrid[pos[1]][pos[0]-1] == 0 && facing != 1) {
            turn(currFacing, 3, robot);
            currFacing = 3;
            if(robot.move()) {
                move(new int[]{pos[1], pos[0]+1}, 3, robot);
                currFacing = 1;
            }
        }
        // move up if it is not going back
        if(maxGrid[pos[1]+1][pos[0]] == 0 && facing != 2) {
            turn(currFacing, 0, robot);
            currFacing = 0;
            if(robot.move()) {
                move(new int[]{pos[1]+1, pos[0]}, 0, robot);
                currFacing = 2;
            }
        }
        // move down if it is not going back
        if(maxGrid[pos[1]-1][pos[0]] == 0 && facing != 0) {
            turn(currFacing, 2, robot);
            currFacing = 2;
            if(robot.move()) {
                move(new int[]{pos[1]-1, pos[0]}, 0, robot);
                currFacing = 0;
            }
        }
        turn(currFacing, (facing+2)%4, robot);
        robot.move();
    }

    public void turn(int facing, int direction, Robot robot) {
        while (facing != direction) {
            robot.turnRight();
            facing = facing+1%4;
        }
    }
}

