package algorithms;


import org.junit.jupiter.api.Test;

import static global.GlobalValues.*;

class IDATest {
    @Test
    void doIterativeDeepeningSearchSimple() {
        IDA ida = new IDA();
        String puzzleString =
                "3\n" +
                        "7 2 1\n" +
                        "8 4 5\n" +
                        "0 3 6\n";
        ida.doIterativeDeepeningSearch(puzzleString, MANHATTAN_DISTANCE);
        System.out.print(ida.toString());
    }
}