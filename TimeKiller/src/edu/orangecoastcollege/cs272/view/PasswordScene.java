package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class PasswordScene {
	private static Controller controller = Controller.getInstance();

	@FXML
	private TextField newPasswordTF;
	@FXML
	private TextField currentPasswordTF;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	private Label newPasswordErrorLabel;

	// Event Listener on Button.onAction
	@FXML
	public void loadAccountScene(ActionEvent event) {
		ViewNavigator.loadScene("Account", ViewNavigator.ACCOUNT_SCENE);
	}

	// Event Listener on Button.onAction
	@FXML
	public boolean editPassword() {
		String currentPassword = currentPasswordTF.getText();
		String newPassword = newPasswordTF.getText();

		passwordErrorLabel.setVisible(currentPassword.isEmpty());
		if (passwordErrorLabel.isVisible())
			return false;
		if (controller.changePassword(currentPassword, newPassword) == "FAILURE")
			newPasswordErrorLabel.setVisible(true);
		else {
			ViewNavigator.loadScene("Account", ViewNavigator.ACCOUNT_SCENE);
		}

		return false;
	}
}
