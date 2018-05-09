package edu.orangecoastcollege.cs272.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set stage only needs to be called once for the view navigator
        ViewNavigator.setStage(primaryStage);
        ViewNavigator.loadScene("Time Killer", ViewNavigator.SIGN_IN_SCENE);
    }

    public static void main(String[] args) {
        launch(args);
    }



}
