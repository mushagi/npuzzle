import ui.TextBaseUserInterface;
import ui.UserInterface;

class Main {

    public static void main(String[] args) {

        String filename = args[0];
        UserInterface ui = new TextBaseUserInterface();
        ui.setFilename(filename);
        ui.setHeuristic(0);
        ui.run();
    }
}
