package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

public class WinGameScene {

	// Event Listener on Button.onAction
	@FXML
	public void loadGameScene(ActionEvent event) {
	    ViewNavigator.loadScene("Game List", ViewNavigator.GAME_SCENE);
	}
}
