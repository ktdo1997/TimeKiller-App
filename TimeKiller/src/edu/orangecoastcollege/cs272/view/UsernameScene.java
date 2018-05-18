package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class UsernameScene {
	private static Controller controller = Controller.getInstance();

	@FXML
	private TextField newUserNameTF;
	@FXML
	private TextField currentUserNameTF;
	@FXML
	private Label userNameErrorLabel;
	@FXML
	private Label newNameErrorLabel;

	// Event Listener on Button.onAction
	@FXML
	public void loadAccountScene(ActionEvent event) {
		ViewNavigator.loadScene("Account", ViewNavigator.ACCOUNT_SCENE);
	}

	// Event Listener on Button.onAction
	@FXML
	public boolean editUserName() {
		String currentUserName = currentUserNameTF.getText();
		String newUserName = newUserNameTF.getText();

		userNameErrorLabel.setVisible(currentUserName.isEmpty());
		if (userNameErrorLabel.isVisible())
			return false;
		if (controller.changeUserName(currentUserName, newUserName) == "FAILURE")
			newNameErrorLabel.setVisible(true);
		else {
			ViewNavigator.loadScene("Account", ViewNavigator.ACCOUNT_SCENE);
		}

		return false;
	}
}