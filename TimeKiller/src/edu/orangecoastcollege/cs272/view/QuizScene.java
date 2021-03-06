package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class QuizScene {
	

	// Event Listener on Button[#gamesQuizBT].onAction
	@FXML
	public void loadGameQuiz(ActionEvent event) {
		ViewNavigator.loadScene("Game Quiz", ViewNavigator.GAME_QUIZ_SCENE);
		 
	}
	// Event Listener on Button[#mathQuizBT].onAction
	@FXML
	public void loadMathQuiz(ActionEvent event) {
		ViewNavigator.loadScene("Math Quiz", ViewNavigator.MATH_SCENE);
	}
	// Event Listener on Button[#randomQuizBT].onAction
	@FXML
	public void loadRandomQuiz(ActionEvent event) {
		ViewNavigator.loadScene("Random Quiz", ViewNavigator.RANDOM_QUIZ_SCENE);
	}
	// Event Listener on Button[#backBT].onAction
	@FXML
	public void loadMainMenu(ActionEvent event) {
	    ViewNavigator.loadScene("Main Menu", ViewNavigator.MAIN_MENU);
	}
}
