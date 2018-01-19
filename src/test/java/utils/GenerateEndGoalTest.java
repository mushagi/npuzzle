package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static utils.GenerateEndGoal.createEndGoal;

class GenerateEndGoalTest {

    @DisplayName("creating end goal of a puzzle 3")
    @Test
    void creatingAndEndGoalOfAPuzzleUsingAThreeSize() {

        int[][] idealGoal = new int[3][3];

        idealGoal[0][0] = 1;
        idealGoal[0][1] = 2;
        idealGoal[0][2] = 3;
        idealGoal[1][0] = 8;
        idealGoal[1][1] = 0;
        idealGoal[1][2] = 4;
        idealGoal[2][0] = 7;
        idealGoal[2][1] = 6;
        idealGoal[2][2] = 5;

        assertArrayEquals(idealGoal, createEndGoal(3));
    }


    @DisplayName("Creating end goal of a puzzle 4")
    @Test
    void creatingAnEndGoalOfAPuzzleUsingAFourSize() {
        int[][] idealGoal = new int[4][4];

        idealGoal[0][0] = 1;
        idealGoal[0][1] = 2;
        idealGoal[0][2] = 3;
        idealGoal[0][3] = 4;
        idealGoal[1][0] = 12;
        idealGoal[1][1] = 13;
        idealGoal[1][2] = 14;
        idealGoal[1][3] = 5;
        idealGoal[2][0] = 11;
        idealGoal[2][1] = 0;
        idealGoal[2][2] = 15;
        idealGoal[2][3] = 6;
        idealGoal[3][0] = 10;
        idealGoal[3][1] = 9;
        idealGoal[3][2] = 8;
        idealGoal[3][3] = 7;

        assertArrayEquals(idealGoal, createEndGoal(4));

    }

    @DisplayName("Creating end goal of a puzzle 5")
    @Test
    void creatingAnEndGoalOfAPuzzleUsingAFiveSize() {
        int[][] idealGoal = new int[5][5];

        idealGoal[0][0] = 1;
        idealGoal[0][1] = 2;
        idealGoal[0][2] = 3;
        idealGoal[0][3] = 4;
        idealGoal[0][4] = 5;
        idealGoal[1][0] = 16;
        idealGoal[1][1] = 17;
        idealGoal[1][2] = 18;
        idealGoal[1][3] = 19;
        idealGoal[1][4] = 6;
        idealGoal[2][0] = 15;
        idealGoal[2][1] = 24;
        idealGoal[2][2] = 0;
        idealGoal[2][3] = 20;
        idealGoal[2][4] = 7;
        idealGoal[3][0] = 14;
        idealGoal[3][1] = 23;
        idealGoal[3][2] = 22;
        idealGoal[3][3] = 21;
        idealGoal[3][4] = 8;
        idealGoal[4][0] = 13;
        idealGoal[4][1] = 12;
        idealGoal[4][2] = 11;
        idealGoal[4][3] = 10;
        idealGoal[4][4] = 9;

        assertArrayEquals(idealGoal, createEndGoal(5));

    }

    @DisplayName("Creating end goal of a puzzle 6")
    @Test
    void creatingAnEndGoalOfAPuzzleUsingASixSize() {
        int[][] idealGoal = new int[6][6];

        idealGoal[0][0] = 1;
        idealGoal[0][1] = 2;
        idealGoal[0][2] = 3;
        idealGoal[0][3] = 4;
        idealGoal[0][4] = 5;
        idealGoal[0][5] = 6;
        idealGoal[1][0] = 20;
        idealGoal[1][1] = 21;
        idealGoal[1][2] = 22;
        idealGoal[1][3] = 23;
        idealGoal[1][4] = 24;
        idealGoal[1][5] = 7;
        idealGoal[2][0] = 19;
        idealGoal[2][1] = 32;
        idealGoal[2][2] = 33;
        idealGoal[2][3] = 34;
        idealGoal[2][4] = 25;
        idealGoal[2][5] = 8;
        idealGoal[3][0] = 18;
        idealGoal[3][1] = 31;
        idealGoal[3][2] = 0;
        idealGoal[3][3] = 35;
        idealGoal[3][4] = 26;
        idealGoal[3][5] = 9;
        idealGoal[4][0] = 17;
        idealGoal[4][1] = 30;
        idealGoal[4][2] = 29;
        idealGoal[4][3] = 28;
        idealGoal[4][4] = 27;
        idealGoal[4][5] = 10;
        idealGoal[5][0] = 16;
        idealGoal[5][1] = 15;
        idealGoal[5][2] = 14;
        idealGoal[5][3] = 13;
        idealGoal[5][4] = 12;
        idealGoal[5][5] = 11;

        assertArrayEquals(idealGoal, createEndGoal(6));

    }
}