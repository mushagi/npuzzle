package models;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NodeTest {
    @DisplayName("Converting from string to 2d array")
    @Test
    void checkIfPuzzleStringHasBeenConvertedIntoATwoDArray() {
        String puzzleString = "3\n" +
                "0 6 5\n" +
                "2 4 8\n" +
                "3 7 1\n";

        Node node = new Node(puzzleString);

        int size = 3;

        int[][] tempPuzzle = {
                {0,6,5},
                {2,4,8},
                {3,7,1}
        };

        assertEquals(3, node.getPuzzleSize());
        assertArrayEquals(tempPuzzle, node.getPuzzle());
    }


    @DisplayName("Three available moves")
    @Test
    void testBranchingIntoPossiblePlayingMovesFourAvailable() {


        String puzzleString = "3\n" +
                "3 2 6\n" +
                "1 0 4\n" +
                "8 7 5\n";

        Node node = new Node(puzzleString);
        node.initNextNodes();

        puzzleString = "3\n" +
                "3 0 6\n" +
                "1 2 4\n" +
                "8 7 5\n";

        Node nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(0).getPuzzle(), nextNode.getPuzzle());

        puzzleString = "3\n" +
                "3 2 6\n" +
                "1 7 4\n" +
                "8 0 5\n";
        nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(1).getPuzzle(), nextNode.getPuzzle());

        puzzleString = "3\n" +
                "3 2 6\n" +
                "0 1 4\n" +
                "8 7 5\n";
        nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(2).getPuzzle(), nextNode.getPuzzle());

        puzzleString = "3\n" +
                "3 2 6\n" +
                "1 4 0\n" +
                "8 7 5\n";
        nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(3).getPuzzle(), nextNode.getPuzzle());
    }


    @DisplayName("Four available moves")
    @Test
    void testBranchingIntoPossiblePlayingMovesThreeAvailable() {

        String puzzleString = "3\n" +
                "3 2 6\n" +
                "1 4 0\n" +
                "8 7 5\n";

        Node node = new Node(puzzleString);

        node.initNextNodes();

        puzzleString = "3\n" +
                "3 2 0\n" +
                "1 4 6\n" +
                "8 7 5\n";
        Node nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(0).getPuzzle(), nextNode.getPuzzle());

        puzzleString = "3\n" +
                "3 2 6\n" +
                "1 4 5\n" +
                "8 7 0\n";
        nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(1).getPuzzle(), nextNode.getPuzzle());

        puzzleString = "3\n" +
                "3 2 6\n" +
                "1 0 4\n" +
                "8 7 5\n";
        nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(2).getPuzzle(), nextNode.getPuzzle());
    }

    @DisplayName("Four available moves")
    @Test
    void testBranchingIntoPossiblePlayingMovesTwoAvailable() {

        String puzzleString = "3\n" +
                "1 2 3\n" +
                "0 8 4\n" +
                "7 6 5\n";

        Node node = new Node(puzzleString);

        node.initNextNodes();
        puzzleString = "3\n" +
                "0 2 3\n" +
                "1 8 4\n" +
                "7 6 5\n";
        Node nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(0).getPuzzle(), nextNode.getPuzzle());

        puzzleString = "3\n" +
                "1 2 3\n" +
                "7 8 4\n" +
                "0 6 5\n";
        nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(1).getPuzzle(), nextNode.getPuzzle());

        puzzleString = "3\n" +
                "1 2 3\n" +
                "8 0 4\n" +
                "7 6 5\n";
        nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(2).getPuzzle(), nextNode.getPuzzle());
    }


    @DisplayName("Four available moves")
    @Test
    void testBranchingIntoPossiblePlayingMovesRealTwoAvailable() {

        String puzzleString = "3\n" +
                "0 5 6\n" +
                "1 8 4\n" +
                "3 2 7";

        Node node = new Node(puzzleString);
        node.initNextNodes();

        puzzleString = "3\n" +
                "1 5 6\n" +
                "0 8 4\n" +
                "3 2 7\n";
        Node nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(0).getPuzzle(), nextNode.getPuzzle());

        puzzleString = "3\n" +
                "5 0 6\n" +
                "1 8 4\n" +
                "3 2 7\n";
        nextNode = new Node(puzzleString);
        assertArrayEquals(node.getNextNodes().get(1).getPuzzle(), nextNode.getPuzzle());


        assertEquals(node.getNextNodes().size(), 2);
    }



}