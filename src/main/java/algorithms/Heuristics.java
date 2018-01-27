package algorithms;

import java.awt.*;

import static global.GlobalValues.*;


class Heuristics {

    static int manhattanDistance(int[][] stateGrid, int[][] goalGrid) {

        int sum;
        sum = getDistanceCost(stateGrid, goalGrid);

        return sum;
    }

    private static int missPlacedTiles(int[][] stateGrid, int[][] goalGrid) {
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
                if (value == 0) continue;
                Point expectedPoint = getExpectedPoint(goalGrid, value);
                int distanceX = x - expectedPoint.x;
                int distanceY = y - expectedPoint.y;
                sum += Math.abs(distanceX) + Math.abs(distanceY);
            }
        }
        return sum;
    }


    static Point getExpectedPoint(int[][] goalGrid, int value) {
        Point expectedPoint = new Point();
        expectedPoint.x = -1;
        expectedPoint.y = -1;

        for (int y = 0; y < goalGrid.length; y++)
            for (int x = 0; x < goalGrid.length; x++)
                if (goalGrid[y][x] == value)
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

    static int tilesOutOfRowAndCol(int[][] stateGrid, int[][] goal) {
        int count = 0;
        int y = 0, x = 0, length = stateGrid.length;

        while (y < length) {
            while (x < length) {
                int stateValue = stateGrid[y][x];
                if (stateValue != 0) {
                    if (!isRightRow(stateValue, y, goal))
                        count++;
                    if (!isRightCol(stateValue, x, goal))
                        count++;
                }
                x++;
            }
            x = 0;
            y++;
        }
        return count;
    }

    private static boolean isRightRow(int value, int y, int goal[][]) {
        int x = 0;
        while (x < goal.length) {
            int goalValue = goal[y][x];
            if (goalValue == value)
                return true;
            x++;
        }
        return false;
    }


    private static boolean isRightCol(int value, int x, int goal[][]) {
        int y = 0;
        while (y < goal.length) {
            int goalValue = goal[y][x];
            if (goalValue == value)
                return true;
            y++;
        }
        return false;
    }


}
