package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class JFXApp  extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ResultWindow.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root,600,800);
        ResultWindowController resultWindowController = (ResultWindowController) loader.getController();
        resultWindowController.setUpEnvironment();
        stage.setTitle("NPuzzle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
