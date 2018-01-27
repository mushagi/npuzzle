package ui;

public class GraphicalUserInterface extends UserInterface{


    @Override
    void display() {
        new Thread() {
            @Override
            public void run() {
                javafx.application.Application.launch(JFXApp.class);
            }
        }.start();

    }
}
