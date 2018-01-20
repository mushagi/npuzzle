package algorithms;

import models.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Tools.printPuzzle;

class IDATest {
    @Test
    void doIterativeDeepeningSearchSimple() {
        IDA ida = new IDA();
        String puzzleString = "3\n" +
                "0 5 6\n" +
                "1 8 4\n" +
                "3 2 7";

        Node node = new Node(puzzleString);
        ida.doIterativeDeepeningSearch(node);
    }

}