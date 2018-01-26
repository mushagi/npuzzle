package ui;

import algorithms.IDA;
import models.Node;

import java.util.Stack;

import static algorithms.IsSolvable.isPuzzleSolvable;
import static algorithms.ValidateFile.isFileValid;
import static global.GlobalValues.*;
import static utils.Tools.getDirection;
import static utils.Tools.getPuzzleString;
import static utils.Tools.printPuzzle;

public class UserInterface {

    private String filename;
    long time;
    int complexity;
    int moves;
    private int heuristic;
    private String result;
    public Stack<Node> solvedPuzzlePath;

    public void setShowingSolvingProcess(boolean showingSolvingProcess) {
        isShowingSolvingProcess = showingSolvingProcess;
    }

    boolean isShowingSolvingProcess;

    public void run() {
        if (!isFileValid(filename)) {
            System.out.println("Invalid file.");
        }
        else if(solvePuzzle()) display();
    }


    private boolean solvePuzzle() {
        IDA ida;
        String puzzleString;
        puzzleString = getPuzzleString(filename);
        if (isPuzzleSolvable(puzzleString)) {
            System.out.println("puzzle is unsolvable");

            printPuzzle(new Node(puzzleString));
            return false;
        }
        System.out.println("Searching for the ultimate solution...");
        ida= new IDA();

        ida.doIterativeDeepeningSearch(puzzleString, heuristic);
        time = ida.getTime();
        complexity = ida.getComplexity();
        solvedPuzzlePath = ida.getStack();
        result = ida.toString();
        moves = solvedPuzzlePath.size();
        resultTime = time ;
        resultComplexity = complexity;
        resultMoves = moves;
        resultHeuristic = heuristic;
        resultSolvedPuzzlePath = solvedPuzzlePath;
        resultPuzzleSize = solvedPuzzlePath.get(0).getPuzzleSize();
        updateDirection();

        return true;
    }

    void display() {
        System.out.println(result);
    }


    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    public void updateDirection()
    {
        int[][] prevGrid = null;
        for (Node node : solvedPuzzlePath) {
            node.setDirection(getDirection(node.getPuzzle(), prevGrid));
            prevGrid = node.getPuzzle();
        }
    }


}
