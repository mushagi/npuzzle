package algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static algorithms.Heuristics.getExpectedPoint;
import static algorithms.Heuristics.manhattanDistance;
import static org.junit.jupiter.api.Assertions.*;

class HeuristicsTest {

    @DisplayName("The Manhattan Distance")
    @Test
    void checkManhattanDistanceReturnValue() {
        int[][] stateGrid = {
                {1,2,3},
                {0,8,4},
                {7,6,5}
        };

        assertEquals(1, manhattanDistance(stateGrid));

        int[][] stateGrid2 = {
                {1,2,3},
                {8,5,4},
                {7,0,6}
        };

        assertEquals(3, manhattanDistance(stateGrid2));

    }

    @Test
    @DisplayName("Get expected co-ordinates")
    void testingThatTheExpectedCoordinatesOfAGoalCanBeFetchedAccordingToThePositionOfANumber() {
        int[][] gridGoal = {
                {1,2,3},
                {8,0,4},
                {7,6,5}
        };

        Point valueFour = new Point(2,1);
        int value = 4;
        assertEquals(valueFour, getExpectedPoint(gridGoal, value));

        Point valueFive = new Point(2,2);
        value = 5;
        assertEquals(valueFive, getExpectedPoint(gridGoal, value));

        Point valueTwo = new Point(1,0);
        value = 2;
        assertEquals(valueTwo, getExpectedPoint(gridGoal, value));

    }

}