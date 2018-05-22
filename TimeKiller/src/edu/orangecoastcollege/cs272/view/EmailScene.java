package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class EmailScene {
	private static Controller controller = Controller.getInstance();
	
	@FXML
	private TextField newEmailTF;
	@FXML
	private TextField currentEmailTF;
	@FXML
	private Label emailErrorLabel;
	@FXML
	private Label newEmailErrorLabel;

	// Event Listener on Button.onAction
		@FXML
		public void loadAccountScene(ActionEvent event) {
			ViewNavigator.loadScene("Account", ViewNavigator.ACCOUNT_SCENE);
		}

		// Event Listener on Button.onAction
		@FXML
		public boolean editEmail() {
			String currentEmail = currentEmailTF.getText();
			String newEmail = newEmailTF.getText();

			emailErrorLabel.setVisible(currentEmail.isEmpty());
			if (emailErrorLabel.isVisible())
				return false;
			if (controller.changeEmail(currentEmail, newEmail) == "FAILURE")
				newEmailErrorLabel.setVisible(true);
			else {
				ViewNavigator.loadScene("Account", ViewNavigator.ACCOUNT_SCENE);
			}

			return false;
		}
	}