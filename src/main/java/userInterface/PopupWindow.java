package userInterface;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PopupWindow extends Application {
    final int[][] boardSolved ={
            {3, 8, 9, 5, 2, 7, 1, 4, 6},
            {7, 6, 1, 9, 8, 4, 2, 5, 3},
            {4 ,2 ,5 ,1 ,6, 3, 8, 9, 7},
            {8, 5, 7, 3, 9, 1, 6, 2, 4},
            {2, 3 ,4 ,6 ,5 ,8 ,9, 7, 1},
            {9, 1, 6, 7, 4, 2, 5, 3, 8},
            {1 ,4 ,8 ,2 ,7, 9, 3, 6, 5},
            {5, 7, 2, 8, 3, 6, 4, 1, 9},
            {6, 9, 3, 4, 1, 5, 7, 8, 2}
    };

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Solution");
        Text text = new Text();
        HBox layout = new HBox(10);
        VBox vbox1 = new VBox(10);
        VBox vbox2 = new VBox(10);

        Button row1ShowButton = new Button("Show first row");
        Button row1HideButton = new Button("Hide");
        row1HideButton.setDisable(true);
        Button row2ShowButton = new Button("Show second row");
//        Button row2HideButton = new Button("Hide second row");
//        row2HideButton.setDisable(true);
        Button row3ShowButton = new Button("Show third row");
//        Button row3HideButton = new Button("Hide third row");
//        row3HideButton.setDisable(true);
        Button row4ShowButton = new Button("Show fourth row");
//        Button row4HideButton = new Button("Hide fourth row");
//        row4HideButton.setDisable(true);
        Button row5ShowButton = new Button("Show fifth row");
//        Button row5HideButton = new Button("Hide fifth row");
//        row5HideButton.setDisable(true);
        Button row6ShowButton = new Button("Show sixth row");
//        Button row6HideButton = new Button("Hide sixth row");
//        row6HideButton.setDisable(true);
        Button row7ShowButton = new Button("Show seventh row");
//        Button row7HideButton = new Button("Hide seventh row");
//        row7HideButton.setDisable(true);
        Button row8ShowButton = new Button("Show eighth row");
//        Button row8HideButton = new Button("Hide eighth row");
//        row8HideButton.setDisable(true);
        Button row9ShowButton = new Button("Show ninth row");
//        Button row9HideButton = new Button("Hide ninth row");
//        row9HideButton.setDisable(true);

        List<Button> showButtonList = new ArrayList<>();
        List<Button> hideButtonList = new ArrayList<>();

        showButtonList.add(row1ShowButton);
        showButtonList.add(row2ShowButton);
        showButtonList.add(row3ShowButton);
        showButtonList.add(row4ShowButton);
        showButtonList.add(row5ShowButton);
        showButtonList.add(row6ShowButton);
        showButtonList.add(row7ShowButton);
        showButtonList.add(row8ShowButton);
        showButtonList.add(row9ShowButton);

        hideButtonList.add(row1HideButton);
//        hideButtonList.add(row2HideButton);
//        hideButtonList.add(row3HideButton);
//        hideButtonList.add(row4HideButton);
//        hideButtonList.add(row5HideButton);
//        hideButtonList.add(row6HideButton);
//        hideButtonList.add(row7HideButton);
//        hideButtonList.add(row8HideButton);
//        hideButtonList.add(row9HideButton);

        for(int i = 0; i<9; i++){
            int finalI = i;
            showButtonList.get(i).setOnAction(event->{
                StringBuilder boardString = new StringBuilder();
                for(int j = 0; j < 9; j++){
                    boardString.append(boardSolved[finalI][j]).append(" ");
                    if(j==8){
                        boardString.append("\n");
                    }
                }
                text.setText(String.valueOf(boardString));
                row1ShowButton.setDisable(true);
                row1HideButton.setDisable(false);
            });
        }

        hideButtonList.forEach(button -> button.setOnAction(
                event -> {
                    text.setText("");
                    button.setDisable(true);
                    row1ShowButton.setDisable(false);
                }
        ));

        primaryStage.setWidth(300);
        primaryStage.setHeight(300);

        vbox1.getChildren().addAll(showButtonList);
        vbox2.getChildren().addAll(hideButtonList);

        layout.setStyle("-fx-background-color: cornsilk; -fx-padding: 10;");
        layout.getChildren().add(vbox1);
        layout.getChildren().add(vbox2);
        StackPane.setAlignment(vbox1, Pos.CENTER);
        layout.getChildren().addAll(text);
        primaryStage.setScene(new Scene(layout));
        primaryStage.show();
    }
}
