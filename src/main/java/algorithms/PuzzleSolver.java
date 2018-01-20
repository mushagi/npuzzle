package algorithms;

import models.Node;

class PuzzleSolver {

    private final Node unsolvedPuzzle;

    private int[][] endGoal;

    public PuzzleSolver(String puzzleString) {
        this.unsolvedPuzzle = new Node(puzzleString);

    }


}
