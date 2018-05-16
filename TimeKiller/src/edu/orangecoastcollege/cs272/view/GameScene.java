package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

public class GameScene {

	// Event Listener on Button.onAction
	@FXML
	public void loadMainMenu(ActionEvent event)
    {
        ViewNavigator.loadScene("Main Menu", ViewNavigator.MAIN_MENU);
    }
}
