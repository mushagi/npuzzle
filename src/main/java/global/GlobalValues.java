package global;

import models.Node;

import java.util.Stack;

public class GlobalValues {
    public static final int MANHATTAN_DISTANCE = 0;
    public static final int MISPLACED_TILES = 1;
    public static final int TILES_OUT_OF_ROW_AND_COL = 2;
    public static final int MAX_INT = 2147483647;

    public static long resultTime;
    public static int resultComplexity;
    public static int resultMoves;
    public static  int resultHeuristic;
    public static  Stack<Node> resultSolvedPuzzlePath;
    public static int resultPuzzleSize;
    public  enum direction{
        left, right, up , down
    }



}
