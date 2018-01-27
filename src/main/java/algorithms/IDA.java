package algorithms;

import models.Node;

import java.util.Stack;

import static algorithms.Heuristics.getHeuristicsValue;
import static global.GlobalValues.MAX_INT;
import static utils.GenerateEndGoal.createEndGoal;
import static utils.Tools.isMatchingPuzzles;
import static utils.Tools.printPuzzle;

public class IDA {
    private static final int FOUND = -1;
    private static int[][] goal;
    private int complexity = 0;
    private Stack<Node> openStack;
    private Stack<Node> closedStack = new Stack<>();
    private long time = 0;
    private int heuristics;


    public int getComplexity() {
        return complexity;
    }

    public Stack<Node> getOpenStack() {
        return openStack;
    }

    public long getTime() {
        return time;
    }

    public void doIterativeDeepeningSearch(String puzzleString, int heuristics) {
        int threshold;
        int temp;
        Node initNode;

        this.heuristics = heuristics;
        initNode = new Node(puzzleString);
        goal = createEndGoal(initNode.getPuzzleSize());
        threshold = getHeuristicsValue(initNode.getPuzzle(), goal, heuristics);
        openStack = new Stack<>();

        long startTime = System.currentTimeMillis();
        while (true) {
            openStack.push(initNode);
            temp = search(0, threshold);
            if (temp == FOUND) break;
            threshold = temp;
            closedStack.empty();
            openStack.empty();
            System.gc();
        }
        long endTime   = System.currentTimeMillis();
        time = endTime - startTime;

    }

    private int search(int g, int threshold) {
        Node node;
        int fScore;
        int min;
        if (complexity == 3050000)
            System.out.println("It's taking too long...");
        if (complexity == 3060000)
            System.out.println("Program about to run out of heap space...");
        if (complexity == 3090000)
        {
            System.out.println("Shutting down the program due to space.");
            System.exit(0);
        }
        complexity++;
        node = openStack.lastElement();
        fScore = g + getHeuristicsValue(node.getPuzzle(), goal, heuristics);

        if (fScore > threshold) return fScore;
        if (isMatchingPuzzles(node.getPuzzle(), goal)) return FOUND;

        min = MAX_INT;
        node.initNextNodes();

        for (Node tempNode : node.getNextNodes()) {
            if (!isStateRead(tempNode.getPuzzle())) {
                openStack.push(tempNode);
                int temp = search(g++, threshold);
                if (temp == FOUND) return FOUND;
                if (temp < min) min = temp;
                closedStack.push(node);
                openStack.pop();
            }
        }
        return min;
    }

    private boolean isStateRead(int[][] puzzle) {
        for (Node tempState : openStack)
            if (isMatchingPuzzles(puzzle, tempState.getPuzzle()))
                return true;
        return false;
    }

    private String getSolvedPuzzles() {
        StringBuilder tempString = new StringBuilder();
        for (Node node : openStack)
            tempString.append(printPuzzle(node)).append("\n___________________________\n");
        return tempString.toString();
    }

    @Override
    public String toString() {
        return "IDA{\n" +
                "complexity =\t" + complexity +
                "\nNumber of moves=\t" + openStack.size() +
                "\ntime =\t" + (time/1000.0) +" seconds"+ "\n" +
                "\n"+ getSolvedPuzzles()  +
                "\n}";
    }
}
