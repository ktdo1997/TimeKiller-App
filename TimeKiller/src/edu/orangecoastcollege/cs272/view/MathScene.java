package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class MathScene {
	@FXML
	private Button easyBT;
	@FXML
	private Button hardBT;
	@FXML
	private Button extremelyBT;
	@FXML
	private Button backBT;
	@FXML
	private Label mathLevelLabel;

	// Event Listener on Button[#easyBT].onAction
	@FXML
	public void loadMathEasy(ActionEvent event) {
		ViewNavigator.loadScene("Easy", ViewNavigator.MATH_EASY_SCENE);
	}
	// Event Listener on Button[#hardBT].onAction
	@FXML
	public void loadMathHard(ActionEvent event) {
		ViewNavigator.loadScene("Hard", ViewNavigator.MATH_HARD_SCENE);
	}
	// Event Listener on Button[#extremelyBT].onAction
	@FXML
	public void loadMathExtreme(ActionEvent event) {
		ViewNavigator.loadScene("Extreme", ViewNavigator.MATH_EXTREME_SCENE);
	}
	// Event Listener on Button[#backBT].onAction
	@FXML
	public void loadQuizScene(ActionEvent event) {
		
			ViewNavigator.loadScene("Quiz", ViewNavigator.QUIZ_SCENE);
		}
}
    