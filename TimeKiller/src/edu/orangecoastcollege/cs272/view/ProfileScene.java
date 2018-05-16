package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class ProfileScene {
	@FXML
	private Button quizBT;
	@FXML
	private Button diceBT;
	@FXML
	private Button guessingBT;
	@FXML
	private Button backBT;
	@FXML
	private Label userProfileLabel;

	// Event Listener on Button[#backBT].onAction
	@FXML
	public void loadMainMenu(ActionEvent event) {
        ViewNavigator.loadScene("Main Menu", ViewNavigator.MAIN_MENU);
	}
}
