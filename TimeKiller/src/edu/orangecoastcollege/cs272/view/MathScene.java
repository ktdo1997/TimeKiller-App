package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class MathScene {
	@FXML
	private Label mathLevelLabel;

	@FXML
	public void loadMathEasy(ActionEvent event) {
		ViewNavigator.loadScene("Easy", ViewNavigator.MATH_EASY_SCENE);
	}
	
	@FXML
	public void loadMathHard(ActionEvent event) {
		ViewNavigator.loadScene("Hard", ViewNavigator.MATH_HARD_SCENE);
	}
	
	@FXML
	public void loadMathNormal(ActionEvent event) {
		ViewNavigator.loadScene("Normal", ViewNavigator.MATH_NORMAL_SCENE);
	}
	
	@FXML
	public void loadQuizScene(ActionEvent event) {
		
			ViewNavigator.loadScene("Quiz", ViewNavigator.QUIZ_SCENE);
		}
}
    
