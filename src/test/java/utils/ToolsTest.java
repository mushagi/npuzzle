package utils;

import global.GlobalValues;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.Tools.getDirection;
import static utils.Tools.getPuzzleString;
import static utils.Tools.removeComments;

class ToolsTest {


    @Test
    public void testGetPuzzleString()
    {
        String line = getPuzzleString("Musha# adasdas\nMusha");

        assertEquals("Musha", line);
    }

    @Test
    public void testRemoveComments()
    {
        String line = removeComments("Musha# adasdas");
        assertEquals("Musha", line);
    }

    @Test
    public void testGetDirection()
    {

        int[][] current = {
                {0,2,3},
                {6,5,4},
                {1,8,7}
        };

        int[][] next= {
                {6,2,3},
                {0,5,4},
                {1,8,7}
        };

        GlobalValues.direction direction = getDirection(current, next);
        assertEquals(GlobalValues.direction.right, direction);
    }
}