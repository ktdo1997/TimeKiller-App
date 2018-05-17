package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class ForgotAccountScene {
	@FXML
	private TextField emailTF;
	@FXML
	private Label wrongEmailLabel;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label iDLabel;
	@FXML
	private Label passwordLabel;

	// Event Listener on Button.onAction
	@FXML
	public boolean giveInfor() {
	    String email = emailTF.getText();
	    return false;
	}
	// Event Listener on Button.onAction
	@FXML
	public void loadSignIn(ActionEvent event) {
	    ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);
	}
}
