package algorithms;


import models.Node;
import org.junit.jupiter.api.Test;

import static algorithms.IsSolvable.isPuzzleSolvable;

class IDATest {
    @Test
    void doIterativeDeepeningSearchSimple() {
        IDA ida = new IDA();
        String puzzleString =
               "3\n" +
                       "4 8 5\n" +
                       "3 2 0\n" +
                       "6 1 7\n";


        Node node = new Node(puzzleString);
        if (!isPuzzleSolvable(node)){ System.exit(0); System.out.println("unsolved");}
        ida.doIterativeDeepeningSearch(node);

    }

}