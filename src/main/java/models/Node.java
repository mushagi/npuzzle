package models;

import java.util.ArrayList;

public class Node {
    Node parent;
    int puzzleSize;



    int[][] puzzle;

    public ArrayList<Node> getNextNodes() {
        ArrayList<Node> nextNodes = new ArrayList<>();
        return nextNodes;
    }
    
    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }

    public int getPuzzleSize() {
        return puzzleSize;
    }

    public void setPuzzleSize(int puzzleSize) {
        this.puzzleSize = puzzleSize;
    }
}
