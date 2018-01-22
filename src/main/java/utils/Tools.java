package utils;

import models.Node;

public class Tools {
    private static void printPuzzle(int[][] puzzle) {
        for (int[] aPuzzle : puzzle) {
            for (int x = 0; x < puzzle.length; x++) {
                System.out.print(aPuzzle[x] + " ");
                if (x == puzzle.length - 1) System.out.println();
            }
        }
        System.out.println("__________________________________");
    }
    public static void printPuzzle(Node node) {
        printPuzzle(node.getPuzzle());
    }

    public static boolean isMatchingPuzzles(int[][] puzzleOne, int[][] puzzleTwo) {
        for (int y = 0; y < puzzleOne.length; y++)
            for (int x = 0; x <  puzzleOne.length; x++)
                if (puzzleOne[y][x] != puzzleTwo[y][x])
                    return false;
        return true;
    }
}
