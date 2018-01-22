package algorithms;

import models.Node;

import java.util.Stack;

import static Global.GlobalValues.MANHATTAN_DISTANCE;
import static algorithms.Heuristics.getDistanceCost;
import static algorithms.Heuristics.getHeuristicsValue;
import static utils.GenerateEndGoal.createEndGoal;
import static utils.Tools.isMatchingPuzzles;
import static utils.Tools.printPuzzle;

class IDA {

    private static final int FOUND = -1;
    private static int[][] goal;
    private int moves = 0;

    private Stack<Node> stack;

    public void doIterativeDeepeningSearch(Node node) {
        goal = createEndGoal(node.getPuzzleSize());
        int threshold = getHeuristicsValue(node.getPuzzle(), goal, MANHATTAN_DISTANCE);

        int temp;
        stack = new Stack<>();
        stack.push(node);
        while (true)
        {
            temp = search( 0, threshold);
            if (temp == FOUND) break;
            threshold = temp;
            System.gc();
         }

    }

    private int search(int g, int threshold) {

        Node node = stack.lastElement();

       // if (moves > 3000000) {System.out.println("could not solve puzzle"); System.exit(0);}
        int fScore = g + getHeuristicsValue(node.getPuzzle(), goal, MANHATTAN_DISTANCE);
        if(fScore > threshold) return fScore;

        if (isMatchingPuzzles(node.getPuzzle(), goal)) {
            System.out.println("\nFound");
            printPuzzle(node);
            System.out.println("\n ");
            System.exit(0);
            return FOUND;
        }


        int min = 2147483647;

        node.initNextNodes();

        for (Node tempNode : node.getNextNodes()) {
            if (!isStateRead(tempNode.getPuzzle())) {
                moves++;
                stack.push(tempNode);
                int temp = search(g + getDistanceCost(node.getPuzzle(), tempNode.getPuzzle()), threshold);
                if (temp == FOUND) return FOUND;
                if (temp < min)
                    min = temp;
                stack.pop();
            }
        }
        return min;
    }

    private boolean isStateRead(int[][] puzzle) {
        for (Node tempState: stack)
            if(isMatchingPuzzles(puzzle, tempState.getPuzzle()))
                return true;
        return false;
    }


}
