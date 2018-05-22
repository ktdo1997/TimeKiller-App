package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

import javafx.scene.control.RadioButton;

public class MathEasyScene implements Initializable{
	@FXML
	private Label MathEasyQuestionLabel;
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
	public void loadMathScene(ActionEvent event) {
		ViewNavigator.loadScene("Math", ViewNavigator.MATH_SCENE);
	}
	// Event Listener on Button.onAction
	@FXML
	public void loadNextMathEasy(ActionEvent event) {
		// TODO Autogenerated
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
