package algorithms;


import org.junit.jupiter.api.Test;

import static global.GlobalValues.*;

class IDATest {
    @Test
    void doIterativeDeepeningSearchSimple() {
        IDA ida = new IDA();

        String puzzleString =
               "3\n" +
                       "4 3 2\n" +
                       "7 0 6\n" +
                       "1 5 8\n";


        ida.doIterativeDeepeningSearch(puzzleString, MANHATTAN_DISTANCE);
        System.out.print(ida.toString());
    }
}