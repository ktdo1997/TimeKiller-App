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

	// Event Listener on Button[#quizBT].onAction
	@FXML
	public void loadUserQuizScoreScene(ActionEvent event) {
	    ViewNavigator.loadScene("Quiz Score", ViewNavigator.USER_QUIZ_SCORE_SCENE);
	}
	// Event Listener on Button[#diceBT].onAction
	@FXML
	public void loadUserDiceScoreScene(ActionEvent event) {
	    ViewNavigator.loadScene("Dice Score", ViewNavigator.USER_DICE_SCORE_SCENE);
	}
	// Event Listener on Button[#guessingBT].onAction
	@FXML
	public void loadUserGuessingScoreScene(ActionEvent event) {
	    ViewNavigator.loadScene("Guessing Score", ViewNavigator.USER_GUESSING_SCORE_SCENE);
	}
	// Event Listener on Button[#backBT].onAction
	@FXML
	public void loadMainMenu(ActionEvent event) {
	    ViewNavigator.loadScene("Main Menu", ViewNavigator.MAIN_MENU);
	}
}
