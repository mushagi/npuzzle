package utils;

public class GenerateEndGoal {

    private static int maxSize;
    private static int[][] endGoal;

    public static int[][] createEndGoal(int puzzleSize) {
        maxSize = puzzleSize * puzzleSize;
        endGoal = new int[puzzleSize][puzzleSize];
        findGoal(puzzleSize, 0, 0, 0);
        return endGoal;
    }

    private static void findGoal(int puzzleSize, int count, int yDepth, int xDepth) {
        int y = yDepth, x = xDepth;

        if (x < 0 || y < 0 || count == maxSize) return;
        for (; x < puzzleSize; ++x)
            endGoal[y][x] = (++count == maxSize) ? 0 : count;
        if (x-- == puzzleSize) {
            y++;
            for (; y < puzzleSize; y++)
                endGoal[y][x] = (++count == maxSize) ? 0 : count;
        }
        if ((y-- == puzzleSize && (x-- == (puzzleSize - 1)))) {
            for (; x >= xDepth; x--)
                endGoal[y][x] = (++count == maxSize) ? 0 : count;
        }
        if (++x == xDepth && (y-- == puzzleSize -1)) {
            for (; y > (yDepth); --y)
                endGoal[y][x] = (++count == maxSize) ? 0 : count;
            y++;
            x++;
        }
        findGoal(puzzleSize - 1, count, y, x);
    }

}
