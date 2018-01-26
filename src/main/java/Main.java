import global.GlobalValues;
import ui.GraphicalUserInterface;
import ui.TextBaseUserInterface;
import ui.UserInterface;

import static global.GlobalValues.MANHATTAN_DISTANCE;
import static global.GlobalValues.MISPLACED_TILES;
import static global.GlobalValues.TILES_OUT_OF_ROW_AND_COL;


class Main {

    static String filename = "";
    static boolean gui = false;
    static int heuristic = 0;
    static boolean showSolvingProcess = false;


    public static void initArguments(String[] args) {
        int guiCount = 0;
        int heuristicCount = 0;
        int solvingProcessCount = 0;
        boolean isFilenameFound = false;

        for (String temp: args) {
            char [] tempStringChar = temp.toCharArray();
            if (tempStringChar[0] == '-') {

                if (temp.equals("-gui")) {
                    guiCount++;
                    gui = true;
                }
                else if (temp.equals("-man")) {
                    heuristic = MANHATTAN_DISTANCE;
                    heuristicCount++;

                }
                else if (temp.equals("-mpt")) {
                    heuristic = MISPLACED_TILES;
                    heuristicCount++;

                }
                else if (temp.equals("-trc")) {
                    heuristic = TILES_OUT_OF_ROW_AND_COL;
                    heuristicCount++;

                }
                else if (temp.equals("-s")) {
                    showSolvingProcess = true;
                    solvingProcessCount++;
                }
            }
            else {
                filename = temp;
                isFilenameFound = true;
            }

        }
        if (!isFilenameFound)
        {
            System.out.println("No filename provided");
            System.exit(0);
        }
        if (heuristicCount != 1 || guiCount > 1 || solvingProcessCount > 1 )
        {
            System.out.println("Invalid arguments.");
            System.exit(0);
        }
    }

    public static void main(String[] args)  {
        if (args.length < 1) {
            System.out.println("Usage : npuzzle [-heuristic] [-gui(optional)][filename]\n" +
                    "heuristic : manhattan distance [-man]\n" +
                    "            miss placed tiles [-mpt]\n" +
                    "            Tiles out of row and Col [-trc]\n");
            System.exit(0);
        }
        else if (args.length  > 4)
        {
            System.out.println(args.length + "Invalid number of arguments");
            System.exit(0);
        }
        initArguments(args);
        UserInterface ui = gui ? new GraphicalUserInterface() :  new TextBaseUserInterface();
        ui.setFilename(filename);
        ui.setHeuristic(heuristic);
        ui.setShowingSolvingProcess(showSolvingProcess);
        ui.run();
    }
}
