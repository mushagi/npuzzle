package models;

import java.awt.*;
import java.util.ArrayList;

public class Node {
    private final ArrayList<Node> nextNodes = new ArrayList<>();
    private int puzzleSize;
    private int[][] puzzle;
    private Point blankPosition;

    public Node(String puzzleString) {
        initPuzzle(puzzleString);
    }

    private Node(int[][] puzzle, Point blankPosition) {
        this.puzzle = puzzle;
        this.blankPosition = blankPosition;
    }

    public void initNextNodes() {
        Point top = new Point(blankPosition.x, blankPosition.y - 1);
        Point bottom = new Point(blankPosition.x, blankPosition.y + 1);
        Point left = new Point(blankPosition.x - 1, blankPosition.y);
        Point right = new Point(blankPosition.x + 1, blankPosition.y);

        if (isWithinPuzzleBounds(top)) nextNodes.add(getSwappedPointsNode(top));
        if (isWithinPuzzleBounds(bottom)) nextNodes.add(getSwappedPointsNode(bottom));
        if (isWithinPuzzleBounds(left)) nextNodes.add(getSwappedPointsNode(left));
        if (isWithinPuzzleBounds(right)) nextNodes.add(getSwappedPointsNode(right));
    }

    private Node getSwappedPointsNode(Point tempPoint) {
        Node tempNode;
        int tempPuzzle[][] = createCopyOfPuzzle();
        int temp = tempPuzzle[blankPosition.y][blankPosition.x];
        tempPuzzle[blankPosition.y][blankPosition.x] = tempPuzzle[tempPoint.y][tempPoint.x];
        tempPuzzle[tempPoint.y][tempPoint.x] = temp;
        tempNode = new Node(tempPuzzle, tempPoint);
        return tempNode;
    }

    private int[][] createCopyOfPuzzle() {
        int[][] tempPuzzle = new int[puzzleSize][puzzleSize];
        for (int i = 0; i < puzzleSize; i++) {
            System.arraycopy(puzzle[i], 0, tempPuzzle[i], 0, puzzleSize);
        }
        return tempPuzzle;
    }


    private boolean isWithinPuzzleBounds(Point point) {
        return (point.x >= 0 && point.x < puzzleSize && point.y >= 0 && point.y < puzzleSize);
    }

    private void initPuzzle(String puzzleString) {
        int y = 0, x;
        String[] stringLines;
        stringLines = puzzleString.split("\n");
        for (String tempString : stringLines) {
            String[] numberString = tempString.split("\\s+");
            if (numberString.length == 1) puzzleSize = Integer.parseInt(numberString[0]);
            else {
                if (puzzle == null)
                    puzzle = new int[puzzleSize][puzzleSize];
                x = -1;
                for (String tempNumberString : numberString) {
                    puzzle[y][++x] = Integer.parseInt(tempNumberString);
                    if (puzzle[y][x] == 0) blankPosition = new Point(x, y);
                }
                y++;
            }
        }
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    public int getPuzzleSize() {
        return puzzleSize;
    }

    public ArrayList<Node> getNextNodes() {
        return nextNodes;
    }


}
