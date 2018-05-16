package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class PasswordScene {
	@FXML
	private Button cancelBT;
	@FXML
	private Label passwordLabel;
	@FXML
	private Label currentPasswordLabel;
	@FXML
	private Label passwrodLabel;
	@FXML
	private Label newPasswordLabel;
	@FXML
	private Button editBT;
	@FXML
	private TextField passwordTF;

	// Event Listener on Button[#cancelBT].onAction
	@FXML
	public void loadAccountScene(ActionEvent event) {
	    ViewNavigator.loadScene("Account", ViewNavigator.ACCOUNT_SCENE);
	}
}
