package algorithms;

import models.Node;
import org.junit.jupiter.api.Test;

import static algorithms.IsSolvable.getSpiralGrid;
import static algorithms.IsSolvable.isPuzzleSolvable;
import static org.junit.jupiter.api.Assertions.*;
import static utils.Tools.getPuzzleString;

class IsSolvableTest {


    @Test
    void isPuzzleSolvableTestThree2() {
        //This puzzle is unsolvable
        String puzzleString =
                "3\n" +
                        "3 8 5\n" +
                        "7 0 4\n" +
                        "2 1 6\n";
        assertEquals(false, isPuzzleSolvable(puzzleString));
    }

    @Test
    void isPuzzleSolvableTestFour() {
        //This puzzle is unsolvable
        String puzzleString =
                "4\n" +
                        "9 11 13 15\n" +
                        "2 6 8 1\n" +
                        "12 0 7 4\n" +
                        "10 14 5 3\n";
        assertEquals(false, isPuzzleSolvable(puzzleString));
    }


    @Test
    void spiralGrid() {
        // This puzzle is unsolvable
        String puzzleString =
                "4\n" +
                        "11 1 5 8\n" +
                        "12 15 6 3\n" +
                        "14 10 9 0\n" +
                        "2 4 13 7\n";
        Node node = new Node(puzzleString);

        int [] temp = new int[4*4];
        int [] tem2 = new int[4*4];
        temp = getSpiralGrid(node.getPuzzleSize(),  0,  0,0,  node.getPuzzle(), temp );
        for (int i : temp ){
            System.out.print(i + " ");
        }
      //  assertArrayEquals(tem2, );
    }

    @Test
    void isPuzzleSolvableTestFour2() {
        //This puzzle is unsolvable
        String puzzleString =
                "4\n" +
                        "2 12 7 4\n" +
                        "0 10 14 15\n" +
                        "3 8 13 9\n" +
                        "1 6 5 11\n";
        assertEquals(false, isPuzzleSolvable(puzzleString));
    }


    @Test
    void isPuzzleSolvableTestFour3() {
        //This puzzle is unsolvable
        String puzzleString =
                "4\n" +
                        "2 6 4 0\n" +
                        "14 5 7 9\n" +
                        "12 11 3 15\n" +
                        "8 13 10 1\n";
        assertEquals(false, isPuzzleSolvable(puzzleString));
    }


    @Test
    void isPuzzleSolvableTestThree() {
        //This puzzle is unsolvable
        String puzzleString =
                "3\n" +
                        "1 6 2\n" +
                        "4 8 7\n" +
                        "0 3 5\n";
        assertEquals(false, isPuzzleSolvable(puzzleString));
    }

    @Test
    void isPuzzleSolvableTestSeven1() {
        //This puzzle is unsolvable
        String puzzleString =
                "7\n" +
                        "22 7 28 27 2 19 6\n" +
                        "47 13 36 3 34 40 21\n" +
                        "17 33 9 45 10 43 26\n" +
                        "31 0 32 41 18 37 39\n" +
                        "46 20 29 11 1 15 8\n" +
                        "23 48 12 5 44 24 25\n" +
                        "30 4 38 42 14 16 35\n";

        assertEquals(false, isPuzzleSolvable(puzzleString));
    }

    @Test
    void isPuzzleSolvableTestFive() {
        //This puzzle is unsolvable
        String puzzleString =
                "5\n" +
                        "18 23 24 13 14\n" +
                        "20 17 3 15 10\n" +
                        "1 11 19 5 7\n" +
                        "6 4 8 0 22\n" +
                        "12 2 16 21 9\n";

        assertEquals(false, isPuzzleSolvable(puzzleString));
    }

    @Test
    void isPuzzleSolvableTestFive2() {
        //This puzzle is unsolvable
        String puzzleString =
                "5\n" +
                        "3 10 8 2 15\n" +
                        "9 11 22 7 24\n" +
                        "4 17 13 23 5\n" +
                        "16 0 14 6 1\n" +
                        "20 12 18 21 19\n";

        assertEquals(false, isPuzzleSolvable(puzzleString));
    }


    @Test
    void isPuzzleSolvableTestSeven2() {
        //This puzzle is unsolvable
        String puzzleString =
                "7\n" +
                        "46 48 39 47 18 29 34\n" +
                        "11 28 5 19 31 24 12\n" +
                        "7 10 44 36 42 33 40\n" +
                        "2 32 4 14 27 43 41\n" +
                        "25 21 23 16 26 13 15\n" +
                        "22 45 20 1 9 17 37\n" +
                        "8 38 0 30 35 3 6\n";

        assertEquals(false, isPuzzleSolvable(puzzleString));
    }


    @Test
    void isPuzzleSolvableTestFour4() {
        //This puzzle is unsolvable

        String puzzleString =
                "4\n" +
                        "6 11 8 0\n" +
                        "7 1 13 12\n" +
                        "2 4 14 10\n" +
                        "9 5 15 3\n";

        assertEquals(false, isPuzzleSolvable(puzzleString));
    }

    @Test
    void isPuzzleSolvableTestSevenEight() {
        //This puzzle is unsolvable
        String puzzleString =
                "8\n" +
                        "53 12 28 9 2 45 8 37\n" +
                        "19 44 61 3 4 13 0 30\n" +
                        "43 29 24 20 39 7 58 1\n" +
                        "26 57 27 6 52 15 54 36\n" +
                        "62 35 42 34 60 31 56 41\n" +
                        "5 50 10 49 47 32 33 59\n" +
                        "46 18 40 63 21 51 16 14\n" +
                        "23 38 11 55 22 17 25 48\n";

        assertEquals(false, isPuzzleSolvable(puzzleString));
    }

    @Test
    void isPuzzleSolvableTestSevenEight2() {
        //This puzzle is unsolvable
        String puzzleString =
                "9\n" +
                        "55 8 3 37 33 73 15 61 56\n" +
                        "43 80 78 68 27 24 75 76 26\n" +
                        "66 23 71 28 51 11 19 7 42\n" +
                        "29 31 38 20 34 60 70 17 67\n" +
                        "35 52 58 53 0 6 49 9 47\n" +
                        "50 41 30 40 1 69 39 72 62\n" +
                        "45 14 25 5 2 65 59 46 16\n" +
                        "32 18 64 44 10 12 13 22 77\n" +
                        "4 48 57 21 79 63 36 54 74\n";

        assertEquals(false, isPuzzleSolvable(puzzleString));
    }

}