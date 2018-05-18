package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class UserDiceScoreScene {
	@FXML
	private Label UserDiceScoreLabel;
	@FXML
	private Label UserScoreLabel;
	@FXML
	private Label DiceScoreLabel;

	// Event Listener on Button.onAction
	@FXML
	public void loadProfileScene(ActionEvent event) {
	    ViewNavigator.loadScene("Profile", ViewNavigator.PROFILE_SCENE);
	}
}
