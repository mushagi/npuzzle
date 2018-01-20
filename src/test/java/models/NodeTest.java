package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

class NodeTest {
    @DisplayName("Converting from string to 2d array")
    @Test
    void checkIfPuzzleStringHasBeenConvertedIntoATwoDArray() {
        String puzzleString = "3\n" +
                        "3 2 6\n" +
                        "1 4 0\n"+
                        "8 7 5\n";

        Node node = new Node(puzzleString);

        int size = 3;
        int[][] tempPuzzle = new int[size][size];

        tempPuzzle[0][0] = 3;
        tempPuzzle[0][1] = 2;
        tempPuzzle[0][2] = 6;
        tempPuzzle[1][0] = 1;
        tempPuzzle[1][1] = 4;
        tempPuzzle[1][2] = 0;
        tempPuzzle[2][0] = 8;
        tempPuzzle[2][1] = 7;
        tempPuzzle[2][2] = 5;

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
        assertEquals(3, node.getNextNodes().size());
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
}