package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class GuessingGameScene {
	@FXML
	private Label quizQuestionLabel;
	@FXML
	private Label answerALabel;
	@FXML
	private Label answerBLabel;
	@FXML
	private Label answerCLabel;
	@FXML
	private Label answerDLabel;

	// Event Listener on Button.onAction
	@FXML
	public void loadGameScene(ActionEvent event) {
	    ViewNavigator.loadScene("Game Scene", ViewNavigator.GAME_SCENE);
	}
}
