package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static utils.GenerateEndGoal.createEndGoal;

class GenerateEndGoalTest {

    @DisplayName("creating end goal of a puzzle 3")
    @Test
    void creatingAndEndGoalOfAPuzzleUsingAThreeSize() {
        int[][] idealGoal = new int[][]{
                {1, 2,  3},
                {8, 0,  4},
                {7, 6,  5},
        };
        assertArrayEquals(idealGoal, createEndGoal(3));
    }


    @DisplayName("Creating end goal of a puzzle 4")
    @Test
    void creatingAnEndGoalOfAPuzzleUsingAFourSize() {
        int[][] idealGoal = new int[][]{
                {1,     2,  3,  4},
                {12,    13, 14, 5},
                {11,    0,  15, 6},
                {10,    9,  8,  7}
        };
        assertArrayEquals(idealGoal, createEndGoal(4));

    }

    @DisplayName("Creating end goal of a puzzle 5")
    @Test
    void creatingAnEndGoalOfAPuzzleUsingAFiveSize() {
        int[][] idealGoal = new int[][]{
                {1,     2,  3,  4,  5},
                {16,    17, 18, 19, 6},
                {15,    24, 0,  20, 7,},
                {14,    23, 22, 21, 8},
                {13,    12, 11, 10, 9,}
        };
        assertArrayEquals(idealGoal, createEndGoal(5));
    }


    @DisplayName("Creating end goal of a puzzle 6")
    @Test
    void creatingAnEndGoalOfAPuzzleUsingASixSize() {
        int[][] idealGoal = new int[][]{
                {1,     2,  3,  4,  5,  6},
                {20,    21, 22, 23, 24, 7},
                {19,    32, 33, 34, 25, 8,},
                {18,    31, 0,  35, 26, 9,},
                {17,    30, 29, 28, 27, 10,},
                {16,    15, 14, 13, 12, 11,}
        };
        assertArrayEquals(idealGoal, createEndGoal(6));

    }
}