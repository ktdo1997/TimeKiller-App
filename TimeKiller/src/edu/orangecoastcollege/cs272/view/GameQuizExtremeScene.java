package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

public class GameQuizExtremeScene {
	@FXML
	private Label GameQuizExtremeQuestionLabel;
	@FXML
	private RadioButton rbA;
	@FXML
	private RadioButton rbB;
	@FXML
	private RadioButton rbD;
	@FXML
	private RadioButton rbC;

	// Event Listener on Button.onAction
	@FXML
	public void loadGameQuizScene(ActionEvent event) {
		ViewNavigator.loadScene("GAME QUIZ",ViewNavigator.GAME_QUIZ_SCENE);
	}
	// Event Listener on Button.onAction
	@FXML
	public void loadNextGameQuizExtreme(ActionEvent event) {
		// TODO Autogenerated
	}
}
