package utils;

class GenerateEndGoal {

    private static int maxSize;
    private static int[][] endGoal;

    public static int[][] createEndGoal(int puzzleSize) {
        maxSize = puzzleSize * puzzleSize;
        endGoal = new int[puzzleSize][puzzleSize];
        findGoal(puzzleSize, 0, 0, 0);
        return endGoal;
    }

    private static void findGoal(int puzzleSize, int count, int yDepth, int xDepth) {
        int y, x;
        x = xDepth;
        y = yDepth;

        if (x < 0 || y < 0) return;
        if (count == maxSize) return;

        for (; x < puzzleSize; ++x) {
            endGoal[y][x] = ++count;
            if (count == maxSize) endGoal[y][x] = 0;
        }

        if (x == puzzleSize) {
            y++;
            x--;
            for (; y < puzzleSize; y++) {
                endGoal[y][x] = ++count;
                if (count == maxSize) endGoal[y][x] = 0;
            }


        }
        if ((y == puzzleSize && (x == (puzzleSize - 1)))) {
            y--;
            x--;
            for (; x >= xDepth; x--) {
                endGoal[y][x] = ++count;
                if (count == maxSize) endGoal[y][x] = 0;
            }
        }
        if (x == xDepth - 1 && (y == puzzleSize - 1)) {
            y--;
            x++;
            for (; y > (yDepth); y--) {
                endGoal[y][x] = ++count;
                if (count == maxSize) endGoal[y][x] = 0;
            }
            y++;
            x++;

        }
        findGoal(puzzleSize - 1, count, y, x);
    }

}
