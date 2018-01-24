package algorithms;

import models.Node;

import java.util.Stack;

import static algorithms.Heuristics.getHeuristicsValue;
import static global.GlobalValues.MAX_INT;
import static utils.GenerateEndGoal.createEndGoal;
import static utils.Tools.isMatchingPuzzles;
import static utils.Tools.printPuzzle;

class IDA {
    private static final int FOUND = -1;
    private static int[][] goal;
    private int complexity = 0;
    private Stack<Node> stack;
    private long time = 0;
    private int heuristics;


    public void doIterativeDeepeningSearch(Node node, int heuristics) {
        int threshold;
        int temp;
        this.heuristics = heuristics;

        goal = createEndGoal(node.getPuzzleSize());
        threshold = getHeuristicsValue(node.getPuzzle(), goal, heuristics);
        stack = new Stack<>();
        stack.push(node);

        long startTime = System.currentTimeMillis();
        while (true) {
            temp = search(0, threshold);
            if (temp == FOUND) break;
            threshold = temp;
            System.gc();
        }
        long endTime   = System.currentTimeMillis();
        time = endTime - startTime;

    }

    private int search(int g, int threshold) {
        Node node;
        int fScore;
        int min;

        complexity++;
        node = stack.lastElement();
        fScore = g + getHeuristicsValue(node.getPuzzle(), goal, heuristics);

        if (fScore > threshold) return fScore;
        if (isMatchingPuzzles(node.getPuzzle(), goal)) return FOUND;

        min = MAX_INT;
        node.initNextNodes();

        for (Node tempNode : node.getNextNodes()) {
            if (!isStateRead(tempNode.getPuzzle())) {
                stack.push(tempNode);
                int temp = search(g++, threshold);
                if (temp == FOUND) return FOUND;
                if (temp < min) min = temp;
                stack.pop();
            }
        }
        return min;
    }

    private boolean isStateRead(int[][] puzzle) {
        for (Node tempState : stack)
            if (isMatchingPuzzles(puzzle, tempState.getPuzzle()))
                return true;
        return false;
    }

    private String getSolvedPuzzles() {
        StringBuilder tempString = new StringBuilder();
        for (Node node : stack)
            tempString.append(printPuzzle(node)).append("\n___________________________\n");
        return tempString.toString();
    }




    @Override
    public String toString() {
        return "IDA{\n" +
                "complexity =\t" + complexity +
                "\nNumber of moves=\t" + stack.size() +
                "\ntime =\t" + (time/1000.0) +" seconds"+ "\n" +
                "\n"+ getSolvedPuzzles()  +
                "\n}";
    }
}
