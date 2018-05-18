package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class UserGuessingScoreScene {
	@FXML
	private Label UserGuessingScoreLabel;
	@FXML
	private Label GuessingScoreLabel;

	// Event Listener on Button.onAction
	@FXML
	public void loadProfileScene(ActionEvent event) {
	    ViewNavigator.loadScene("Profile", ViewNavigator.PROFILE_SCENE);
	}
}
