package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class GameScene {
	@FXML
	private Button quizBT;
	@FXML
	private Button diceBT;
	@FXML
	private Button guessingBT;
	@FXML
	private Button backBT;
	@FXML
	private Label selectGamesLabel;

	// Event Listener on Button[#quizBT].onAction
	@FXML
	public void loadQuizScene(ActionEvent event) {
	    ViewNavigator.loadScene("Welcome to Quiz Game", ViewNavigator.QUIZ_SCENE);
	}
	@FXML
    public void loadDiceScene(ActionEvent event) {
        ViewNavigator.loadScene("Welcome to Dice Game", ViewNavigator.DICE_GAME_SCENE);
    }
	// Event Listener on Button[#guessingBT].onAction
	@FXML
	public void loadGuessingGameScene(ActionEvent event) {
	    ViewNavigator.loadScene("Welcome to Guessing Game", ViewNavigator.GUESSING_GAME_SCENE);
	}
	// Event Listener on Button[#backBT].onAction
	@FXML
	public void loadMainMenu(ActionEvent event)
    {
        ViewNavigator.loadScene("Main Menu", ViewNavigator.MAIN_MENU);


	}
}
