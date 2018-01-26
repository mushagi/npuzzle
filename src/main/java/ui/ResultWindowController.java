package ui;

import global.GlobalValues;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.util.Duration;


import java.awt.*;

import static global.GlobalValues.resultPuzzleSize;
import static global.GlobalValues.resultSolvedPuzzlePath;
import static utils.Tools.getPoint;
import static utils.Tools.printPuzzle;

public class ResultWindowController {

    @FXML
    private AnchorPane apnMain;
    private GridPane gpnGrid;

    @FXML
    private Button btnPlay;

    @FXML
    void btnPlay_MouseClicked(MouseEvent event) {

        moveTiles();

    }

    private void moveTiles(){

        StackPane stackPane1 = null;
        StackPane stackPane2 = null;
        GlobalValues.direction prevDirection = null;
        /*
        for (models.Node stackNode: resultSolvedPuzzlePath) {
            prevDirection
            int value = getValue(stackNode);
            /*
            try {
                ObservableList<Node> childrens = gpnGrid.getChildren();
                for (Node node : childrens) {
                    StackPane stackPane = (StackPane) node;
                ObservableList<Node> stackChildrens = stackPane.getChildren();
                if (stackChildrens.size() == 0){
                    stackPane2 = stackPane;
                }
                else
                    for (Node text : stackChildrens) {
                    Text text1 = (Text) text;
                    if (text1.getText().equals("" + value)) {
                        stackPane1 = stackPane;
                    }
                }
            }

            switchTiles(stackPane1, stackPane2);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        }
        */


    }

    private int getValue(models.Node stackNode) {
        Point point = getPoint(0, stackNode.getPuzzle());
        if(stackNode.getDirection() == GlobalValues.direction.down)
            return stackNode.getPuzzle()[(point.y- 1)][point.x];
        else if(stackNode.getDirection() == GlobalValues.direction.down)
            return stackNode.getPuzzle()[(point.y + 1)][point.x];
        else if(stackNode.getDirection() == GlobalValues.direction.right) {
            System.out.println(point.x +" " + point.y);
            System.out.println(printPuzzle(stackNode));
            System.exit(0);
            return stackNode.getPuzzle()[point.y][(point.x + 1)];
        }
        //else if(stackNode.getDirection() == GlobalValues.direction.left)
           // return stackNode.getPuzzle()[point.y ][(point.x - 1)];
        return 0;
    }

    private void switchTiles(StackPane stackPane1, StackPane stackPane2) {
        animateTiles(stackPane1, GlobalValues.direction.down);
    }

    private void animateTiles(StackPane pane, GlobalValues.direction direction)
    {

        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setDuration(Duration.millis(1000));
        translateTransition.setNode(pane);
        if (direction == GlobalValues.direction.right)
            translateTransition.setByX(pane.getLayoutX() + 100);
        if (direction == GlobalValues.direction.left)
            translateTransition.setByX(pane.getLayoutX() - 100);
        if (direction == GlobalValues.direction.up)
            translateTransition.setByY(pane.getLayoutX() - 200);
        if (direction == GlobalValues.direction.down)
            translateTransition.setByY(pane.getLayoutX() + 100);
        translateTransition.setCycleCount(1);
        translateTransition.setAutoReverse(false);
        translateTransition.play();
    }

    private void createGrid() {
        gpnGrid = new GridPane();
        gpnGrid.setPrefSize(500, 100);
        gpnGrid.setLayoutX(50);
        gpnGrid.setLayoutY(50);
        gpnGrid.toFront();
        final int numCols = resultPuzzleSize;
        final int numRows = resultPuzzleSize;
        for (int i = 0; i < numCols; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / numCols);
            gpnGrid.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < numRows; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / numRows);
            gpnGrid.getRowConstraints().add(rowConst);
        }

        for (int i = 0; i < resultPuzzleSize; i++) {
            for (int j = 0; j < resultPuzzleSize; j++) {
                StackPane pane = new StackPane();
                pane.setPrefSize(150, 150);
                pane.setMinSize(150, 150);

                int value = resultSolvedPuzzlePath.get(0).getPuzzle()[i][j];
                if (value != 0) {
                    pane.getStyleClass().add("cell");
                    pane.setStyle("" +
                            "-fx-border-color: black;" +
                            "-fx-effect: dropshadow(three-pass-box, purple, 10, 0, 0, 0);" +
                            " -fx-background-color: orange");
                    gpnGrid.setPadding(new Insets(50, 50, 50, 50));

                    Text text = new Text("" + value);
                    pane.getChildren().add(text);
                    StackPane.setAlignment(text, Pos.CENTER);
                }
                gpnGrid.add(pane, i, j);
            }
        }
        apnMain.getChildren().add(gpnGrid);
    }

    public void setUpEnvironment()
    {
        createGrid();
    }

}
