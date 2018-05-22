package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class GameQuizScene {
	@FXML
	private Button backBT;
	@FXML
	private Label gameLevelLabel;

	// Event Listener on Button.onAction
	@FXML
	public void loadGameEasy(ActionEvent event) {
		ViewNavigator.loadScene("Easy", ViewNavigator.GAME_QUIZ_EASY_SCENE);
	}
	// Event Listener on Button.onAction
	@FXML
	public void loadGameNormal(ActionEvent event) {
		ViewNavigator.loadScene("Normal", ViewNavigator.GAME_QUIZ_NORMAL_SCENE);
	}
	// Event Listener on Button.onAction
	@FXML
	public void loadGameHard(ActionEvent event) {
		ViewNavigator.loadScene("Hard", ViewNavigator.GAME_QUIZ_HARD_SCENE);
	}
	// Event Listener on Button[#backBT].onAction
	@FXML
	public void loadQuizScene(ActionEvent event) {
		ViewNavigator.loadScene("QUIZ", ViewNavigator.QUIZ_SCENE);
	}
}
