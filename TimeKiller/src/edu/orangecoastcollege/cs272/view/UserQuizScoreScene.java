package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UserQuizScoreScene {
	@FXML
	private Label currentUserNameLabel;
	@FXML
	private Label UserQuizScoreLabel;
	@FXML
	private Label GuessingScoreLabel;
	@FXML
	private Label QuizScoreLabel;

	// Event Listener on Button.onAction
	@FXML
	public void loadProfileScene(ActionEvent event) {
	    ViewNavigator.loadScene("Profile", ViewNavigator.PROFILE_SCENE);
	}
	
	// getCrrentUserName
}
