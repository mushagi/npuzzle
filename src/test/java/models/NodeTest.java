package models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    @DisplayName("Node class")
    @Test
    public void checkIfPuzzleStringHasBeenConvertedIntoATwoDArray() {
        String puzzle = "3\n" +
                        "3 2 6\n" +
                        "1 4 0\n"+
                        "8 7 5\n";

        Node node = new Node("");
    }
}