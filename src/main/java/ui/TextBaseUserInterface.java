package ui;

import models.Node;

import static utils.Tools.getDirection;
import static utils.Tools.printPuzzle;

public class TextBaseUserInterface extends UserInterface{

    public TextBaseUserInterface() {

    }

    @Override
    public void display() {
        if (isShowingSolvingProcess) {
            System.out.println("__________________________________");
            System.out.println("            Solving path");
            System.out.println("__________________________________");
            printSolvedPuzzlesAndDirections();
            System.out.println("__________________________________");
        }
        System.out.println("Puzzle solved!");
        System.out.println("Time : \t\t" + time +" ms");
        System.out.println("Complexity : \t" + complexity);
        System.out.println("Moves : \t" + moves);
    }

    public void printSolvedPuzzlesAndDirections() {
        for (Node node : solvedPuzzlePath) {
            System.out.println("Direction = " + node.getDirection());
            System.out.println(printPuzzle(node.getPuzzle()));
        }
    }
}