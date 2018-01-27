package utils;

import global.GlobalValues;
import models.Node;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Tools {
    public static String printPuzzle(int[][] puzzle) {
        StringBuilder tempString = new StringBuilder();
        for (int y = 0; y < puzzle.length; y++) {
            for (int x = 0; x < puzzle.length; x++) {
                tempString.append(puzzle[y][x]).append(" ");
                if (x == puzzle.length - 1) tempString.append("\n");
            }
        }
        return tempString.toString();
    }

    public static String printPuzzle(Node node) {
        return printPuzzle(node.getPuzzle());
    }

    public static boolean isMatchingPuzzles(int[][] puzzleOne, int[][] puzzleTwo) {
        for (int y = 0; y < puzzleOne.length; y++)
            for (int x = 0; x <  puzzleOne.length; x++)
                if (puzzleOne[y][x] != puzzleTwo[y][x])
                    return false;
        return true;
    }

    public static String getPuzzleString(String filename) {
        StringBuilder temp = new StringBuilder();

        try {
            BufferedReader br;
            br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                line = removeComments(line);

                line = line.trim();
                if (line.length() > 0 ) {
                    temp.append(line);
                    temp.append("\n");
                }
            }

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return temp.toString();
    }

    public static String removeComments(String line) {
        int end = line.indexOf('#');
        if (end < 0) return line;
        return (line.substring(0, end));
    }


    public static GlobalValues.direction getDirection(int[][] current, int [][] next) {
        if (current == null || next == null) return null;

        Point currentPoint = getPoint(0, current);
        Point nextPoint = getPoint(0, next);

        if (currentPoint.x > nextPoint.x && currentPoint.y == nextPoint.y )
            return GlobalValues.direction.right;
        else if (currentPoint.x < nextPoint.x && currentPoint.y == nextPoint.y )
            return GlobalValues.direction.left;
        else if (currentPoint.x == nextPoint.x && currentPoint.y > nextPoint.y)
            return GlobalValues.direction.up;
        else if (currentPoint.x == nextPoint.x && currentPoint.y < nextPoint.y)
            return GlobalValues.direction.down;
        else  return null;
    }

    public static Point getPoint(int value, int[][] grid) {
        Point point = new Point();
        point.setLocation(-1, -1);
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid.length; x++) {
                if (grid[y][x] == value) {
                    point.setLocation(x, y);
                    return point;
                }
            }
        }
        return point;
    }
}
