package algorithms;

import java.awt.*;

import static global.GlobalValues.MANHATTAN_DISTANCE;
import static global.GlobalValues.MISPLACED_TILES;


class Heuristics {

    public static int manhattanDistance(int[][] stateGrid, int[][] goalGrid) {

        int sum;
        sum = getDistanceCost(stateGrid, goalGrid);

        return sum;
    }

    private static int missPlacedTiles(int[][] stateGrid, int[][] goalGrid){
        int sum = 0;
        int value;

        for (int[] aStateGrid : stateGrid) {
            for (int x = 0; x < stateGrid.length; x++) {
                value = aStateGrid[x];
                Point expectedPoint = getExpectedPoint(goalGrid, value);
                if (expectedPoint.x == -1 && expectedPoint.y == -1)
                    sum++;

            }
        }
        return sum;
    }

    private static int getDistanceCost(int[][] stateGrid, int[][] goalGrid) {

        int sum = 0;
        int value;

        for (int y = 0; y < stateGrid.length; y++) {
            for (int x = 0; x < stateGrid.length; x++) {
               value = stateGrid[y][x];
               if(value == 0) continue;
               Point expectedPoint = getExpectedPoint(goalGrid, value);
               int distanceX =  x - expectedPoint.x;
               int distanceY = y - expectedPoint.y;
               sum += Math.abs(distanceX) + Math.abs(distanceY);
            }
        }
        return sum;
    }


    public static Point getExpectedPoint(int [][] goalGrid, int value)
    {
        Point expectedPoint = new Point();
        expectedPoint.x = -1;
        expectedPoint.y = -1;

        for (int y = 0; y < goalGrid.length; y++)
            for (int x = 0; x < goalGrid.length; x++)
                if(goalGrid[y][x] == value)
                    expectedPoint.setLocation(x, y);
        return expectedPoint;
    }

    public static int getHeuristicsValue(int[][] stateGrid, int [][] goalGrid, int heuristic) {
        if (heuristic == MANHATTAN_DISTANCE)
            return manhattanDistance(stateGrid, goalGrid);
        else if (heuristic == MISPLACED_TILES)
            return missPlacedTiles(stateGrid, goalGrid);
        return 0;
    }

}
