package ui;

public class TextBaseUserInterface extends UserInterface{

    public TextBaseUserInterface() {
    }

    @Override
    public void display() {
        System.out.println("Puzzle solved!");
        System.out.println("Time : \t\t" + time + "s");
        System.out.println("Complexity : \t" + complexity);
        System.out.println("Moves : \t" + moves);
    }

}