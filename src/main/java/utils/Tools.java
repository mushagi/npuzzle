package utils;

import models.Node;

public class Tools {
    private static String printPuzzle(int[][] puzzle) {
        StringBuilder tempString = new StringBuilder();
        for (int[] aPuzzle : puzzle) {
            for (int x = 0; x < puzzle.length; x++) {
                tempString.append(aPuzzle[x]).append(" ");
                if (x == puzzle.length - 1) tempString.append("\n");
            }
        }
        return tempString.toString();
    }
    public static String printPuzzle(Node node) {
        return printPuzzle(node.getPuzzle());
    }

    public static boolean isMatchingPuzzles(int[][] puzzleOne, int[][] puzzleTwo) {
        for (int y = 0; y < puzzleOne.length; y++)
            for (int x = 0; x <  puzzleOne.length; x++)
                if (puzzleOne[y][x] != puzzleTwo[y][x])
                    return false;
        return true;
    }
}
