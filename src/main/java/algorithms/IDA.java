package algorithms;

import models.Node;

import java.util.ArrayList;

import static Global.GlobalValues.MANHATTAN_DISTANCE;
import static algorithms.Heuristics.getHeuristicsValue;
import static utils.GenerateEndGoal.createEndGoal;
import static utils.Tools.isMatchingPuzzles;
import static utils.Tools.printPuzzle;

public class IDA {

    public static final int FOUND = -1;
    public static int[][] goal;
    public final int MAX_INT = 2147483647;
    private ArrayList<int [][]> readStates = new ArrayList<>();

    public void doIterativeDeepeningSearch(Node node) {
        int threshold = getHeuristicsValue(node.getPuzzle(), MANHATTAN_DISTANCE);
        System.out.println("starting ");
        goal = createEndGoal(node.getPuzzleSize());
        int temp;

        int moves = 0;

        while (true)
        {
            temp = search(node, 0, threshold, moves);
            if (temp == FOUND)
                return;
            threshold = temp;
        }

    }

    private int search(Node node, int g, int threshold, int moves) {
        moves++;
        System.out.println("\nSearching... Move = "+ moves + " threshod " + threshold);
        printPuzzle(node);
        System.out.println("\n");
        readStates.add(node.getPuzzle());

        int fScore = g + getHeuristicsValue(node.getPuzzle(), MANHATTAN_DISTANCE);
        if(fScore > threshold) {

            return fScore;
        }
        if (isMatchingPuzzles(node.getPuzzle(), goal)) {

            System.out.println("\nFound");
            printPuzzle(node);
            System.out.println("\n");

            return FOUND;
        }


        int min = MAX_INT;

        for (Node tempNode : node.getNextNodes())
        {
            if (!isStateRead(tempNode.getPuzzle())) {
                System.out.println("in" + fScore);
                readStates.add(tempNode.getPuzzle());
                int temp = search(tempNode, g + fScore, threshold, moves);
                if (temp == FOUND) {
                    return FOUND;
                }
                readStates.remove(tempNode);
                if (temp < min)
                    min = temp;
            }

        }
        readStates.add(node.getPuzzle());

        return min;
    }

    private boolean isStateRead(int[][] puzzle) {
        for (int[][] tempState: readStates)
            if(isMatchingPuzzles(puzzle, tempState))
                return true;
        return false;
    }


}
