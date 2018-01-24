package algorithms;

import java.awt.*;

import static global.GlobalValues.MANHATTAN_DISTANCE;
import static global.GlobalValues.MISPLACED_TILES;
import static global.GlobalValues.TILES_OUT_OF_ROW_AND_COL;


class Heuristics {

    static int manhattanDistance(int[][] stateGrid, int[][] goalGrid) {

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


  static Point getExpectedPoint(int[][] goalGrid, int value)
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

    static int getHeuristicsValue(int[][] stateGrid, int[][] goalGrid, int heuristic) {
        switch (heuristic) {
            case MANHATTAN_DISTANCE:
                return manhattanDistance(stateGrid, goalGrid);
            case MISPLACED_TILES:
                return missPlacedTiles(stateGrid, goalGrid);
            case TILES_OUT_OF_ROW_AND_COL:
                return tilesOutOfRowAndCol(stateGrid, goalGrid);
        }
        return 0;
    }

    static int tilesOutOfRowAndCol(int[][] stateGrid, int[][] goalGrid) {
        int count = 0;
        int rowCount = 0;
        boolean rowFlag = false;
        for (int y = 0; y < stateGrid.length; y++){
            for (int x = 0; x < stateGrid.length; x++) {
                rowCount++;
                rowFlag = rowFlag || stateGrid[y][x] == goalGrid[y][x];
                if (rowCount == stateGrid.length) {
                    if (rowFlag) count++;
                    rowCount = 0;
                    rowFlag = false;
                }
            }
        }

        return count;
    }

}
