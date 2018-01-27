package algorithms;

import models.Node;


import static utils.Tools.getPoint;


public class    IsSolvable {

    public static boolean isPuzzleSolvable(String puzzleString)
    {
        Node node = new Node(puzzleString);

        int blankPointRow;
        boolean isBlankEven;
        int [] straight = new int[node.getPuzzleSize() * node.getPuzzleSize()];
        straight = getSpiralGrid(node.getPuzzleSize(), 0, 0, 0, node.getPuzzle(), straight);

        int inversions = inversionCount(node.getPuzzleSize(), straight);
        blankPointRow =  node.getPuzzleSize() - (getPoint(0, node.getPuzzle()).y + 1) + 1 ;
        isBlankEven = blankPointRow % 2 == 0;
        if (node.getPuzzleSize() % 2 != 0)
            return inversions % 2 == 0;
        else
        {
            if (!isBlankEven  && inversions % 2 == 0) return true;
            else if(isBlankEven && inversions % 2 == 0) return true;

        }
        return false;
    }

    private static int inversionCount(int n, int[] array)
    {
        int inversion = 0;

        for (int value: array)if (value != 0) {
            inversion += getPreviousValueCount(value, array);
        }
        return inversion;
    }

    private static int getPreviousValueCount(int value, int[] array) {
        int count = value - 1;
        for (int lValue: array) {
            if (lValue != 0) {
                if (lValue == value)
                    break;
                if (lValue < value)
                    count--;
            }
        }

        return count;
    }

    public static int[] getSpiralGrid(int puzzleSize, int count, int yDepth, int xDepth, int[][] straight, int temp[]) {
        int y = yDepth, x = xDepth;

        if (x < 0 || y < 0 || count == puzzleSize) return temp;
        for (; x < puzzleSize; ++x)
            temp[count++] = straight[y][x];
        if (x-- == puzzleSize) {
            y++;
            for (; y < puzzleSize; y++)
                temp[count++] = straight[y][x];
        }
        if ((y-- == puzzleSize && (x-- == (puzzleSize - 1)))) {
            for (; x >= xDepth; x--)
                temp[count++] = straight[y][x];
        }
        if (++x == xDepth && (y-- == puzzleSize -1)) {
            for (; y > (yDepth); --y)
                temp[count++] = straight[y][x];
            y++;
            x++;
        }
        return getSpiralGrid(puzzleSize - 1, count, y, x, straight, temp);
    }

}
