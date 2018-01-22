package algorithms;

import java.awt.*;

import static Global.GlobalValues.MANHATTAN_DISTANCE;


class Heuristics {
    public static int manhattanDistance(int[][] stateGrid, int[][] goalGrid)
    {
        int sum;
        sum = getDistanceCost(stateGrid, goalGrid);

        return sum;
    }

    public static int getDistanceCost(int[][] stateGrid, int[][] goalGrid) {
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

        for (int y = 0; y < goalGrid.length; y++)
            for (int x = 0; x < goalGrid.length; x++)
                if(goalGrid[y][x] == value)
                    expectedPoint.setLocation(x, y);
        return expectedPoint;
    }

    public static int getHeuristicsValue(int[][] stateGrid, int [][] goalGrid, int heuristic) {
        if (heuristic == MANHATTAN_DISTANCE)
            return manhattanDistance(stateGrid, goalGrid);
        return 0;
    }

}
