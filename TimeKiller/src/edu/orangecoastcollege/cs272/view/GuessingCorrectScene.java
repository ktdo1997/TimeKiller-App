package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

public class GuessingCorrectScene {

	// Event Listener on Button.onAction
	@FXML
	public void loadGuessingGameScene(ActionEvent event) {
	    ViewNavigator.loadScene("Guessing Game", ViewNavigator.GUESSING_GAME_SCENE);
	}
}
