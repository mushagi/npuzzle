package algorithms;

import models.Node;

public class IsSolvable {

    public static boolean isPuzzleSolvable(String puzzleString)
    {
        Node node = new Node(puzzleString);

        int items = node.getPuzzleSize() * node.getPuzzleSize();
        int[] straight = new int[items];
        int index = 0, space_row = 0;

        for ( int i=0; i < node.getPuzzleSize(); i++) {
            for (int j = 0; j < node.getPuzzleSize(); j++) {
                straight[index] = node.getPuzzle()[i][j];
                if (node.getPuzzle()[i][j] == 0)
                    space_row = i;
                index++;
            }
        }

        int inversions = inversionCount(items, straight);
        if(node.getPuzzleSize() % 2 != 0)
        {
            if(inversions % 2 == 0)
                return true;
            else
                return false;
        }
        else
        {
            if (space_row % 2 == 0 && inversions % 2 != 0)
                return true;
            if(space_row % 2 != 0 && inversions % 2 == 0)
                return true;
            else
                return false;
        }
    }

    private static int inversionCount(int n, int[] array)
    {
        int inversion = 0;


        for (int i = 0; i < n - 1; i++)
            for (int j = i+1; j < n; j++)
                if(array[j] != 0)
                    if (array[i] > array[j])
                        inversion++;

        return inversion;
    }
}
