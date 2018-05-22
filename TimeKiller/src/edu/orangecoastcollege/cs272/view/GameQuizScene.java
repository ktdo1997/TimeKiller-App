package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class GameQuizScene {
	@FXML
	private Button easyBT;
	@FXML
	private Button hardBT;
	@FXML
	private Button extremelyBT;
	@FXML
	private Button backBT;
	@FXML
	private Label gameLevelLabel;

	// Event Listener on Button[#easyBT].onAction
	@FXML
	public void loadGameEasy(ActionEvent event) {
		ViewNavigator.loadScene("Easy Level ",ViewNavigator.GAME_QUIZ_EASY_SCENE);
	}
	// Event Listener on Button[#hardBT].onAction
	@FXML
	public void loadGameHard(ActionEvent event) {
		ViewNavigator.loadScene("Hard Level",ViewNavigator.GAME_QUIZ_HARD_SCENE);
	}
	// Event Listener on Button[#extremelyBT].onAction
	@FXML
	public void loadGameExtreme(ActionEvent event) {
		ViewNavigator.loadScene("Extremely Level",ViewNavigator.GAME_QUIZ_EXTREME_SCENE);
	}
	// Event Listener on Button[#backBT].onAction
	@FXML
	public void loadQuizScene(ActionEvent event) {
		ViewNavigator.loadScene("QUIZ", ViewNavigator.QUIZ_SCENE);
		
	}
}
