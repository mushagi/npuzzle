package algorithms;


import org.junit.jupiter.api.Test;

import static global.GlobalValues.*;

class IDATest {
    @Test
    void doIterativeDeepeningSearchSimple() {
        IDA ida = new IDA();
        String puzzleString =
               "5\n" +
                       "6 11 7 12 0\n" +
                       "23 13 3 2 18\n" +
                       "24 5 4 17 15\n" +
                       "8 21 19 16 10\n" +
                       "20 9 1 22 14\n";
        ida.doIterativeDeepeningSearch(puzzleString, MANHATTAN_DISTANCE);
        System.out.print(ida.toString());
    }
}