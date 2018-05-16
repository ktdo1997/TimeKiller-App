package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class EmailScene {
	@FXML
	private Button cancelBT;
	@FXML
	private Label emailAdressLabel;
	@FXML
	private Label myEmailLabel;
	@FXML
	private Label emailLabel;
	@FXML
	private Label changeEmailLabel;
	@FXML
	private Button editBT;
	@FXML
	private TextField changeemailTF;

	// Event Listener on Button[#cancelBT].onAction
	@FXML
	public void loadAccountScene(ActionEvent event) {
	    ViewNavigator.loadScene("Account", ViewNavigator.ACCOUNT_SCENE);
	}
}
