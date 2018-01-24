package ui;

import algorithms.IDA;
import models.Node;

import java.util.Stack;

import static algorithms.IsSolvable.isPuzzleSolvable;
import static algorithms.ValidateFile.isFileValid;
import static utils.Tools.getPuzzleString;
import static utils.Tools.printPuzzle;

public class UserInterface {

    private String filename;
    long time;
    int complexity;
    int moves;
    private int heuristic;
    private String result;

    public void run() {
        if (!isFileValid(filename)) {
            System.out.println("Invalid file.");
        }
        else if(solvePuzzle())display();
    }


    private boolean solvePuzzle() {
        IDA ida;
        String puzzleString;

        puzzleString = getPuzzleString(filename);
        if (isPuzzleSolvable(puzzleString)) {
            System.out.println("Puzzle is unsolvable.");
            printPuzzle(new Node(puzzleString));
            return false;
        }

        ida= new IDA();
        ida.doIterativeDeepeningSearch(puzzleString, heuristic);
        time = ida.getTime();
        complexity = ida.getComplexity();
        Stack<Node> solvedPuzzlePath = ida.getStack();
        result = ida.toString();
        moves = solvedPuzzlePath.size();
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
}
