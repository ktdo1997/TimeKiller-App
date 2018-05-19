package edu.orangecoastcollege.cs272.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import edu.orangecoastcollege.cs272.model.Quiz;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GuessingGameScene implements Initializable{
	
	private static Controller controller = Controller.getInstance();
	
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
	@FXML
	private Button a;
	@FXML
	private Button b;
	@FXML
	private Button c;
	@FXML
	private Button d;

	// Event Listener on Button.onAction
	@FXML
	public void loadGameScene(ActionEvent event) 
	{
	    ViewNavigator.loadScene("Game Scene", ViewNavigator.GAME_SCENE);
	}
	
	public void initialize(URL location, ResourceBundle resources)
	{
		quizQuestionLabel.setText(controller.getAllQuiz().get(0).getQuestion());
	}
}
