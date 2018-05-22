package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class AccountScene {
    private static Controller controller = Controller.getInstance();

	@FXML
	private Button userNameBT;
	@FXML
	private Button passwordBT;
	@FXML
	private Button emailBT;
	@FXML
	private Button backBT;
	@FXML
	private Label AccountLabel;
	@FXML
	private Button deleteAccountBT;

	// Event Listener on Button.onAction
	@FXML
    public void loadUsernameScene(ActionEvent event) {
        ViewNavigator.loadScene("User Name", ViewNavigator.USERNAME_SCENE);
    }
    // Event Listener on Button.onAction
    @FXML
    public void loadPasswordScene(ActionEvent event) {
        ViewNavigator.loadScene("Password", ViewNavigator.PASSWORD_SCENE);

    }
    // Event Listener on Button.onAction
    @FXML
    public void loadEmailScene(ActionEvent event) {
        ViewNavigator.loadScene("Email", ViewNavigator.EMAIL_SCENE);
    }
    // Event Listener on Button.onAction
    @FXML
    public void loadMainMenu(ActionEvent event) {
        ViewNavigator.loadScene("Main Menu", ViewNavigator.MAIN_MENU);
	}
    @FXML
    public void deleteAccount(ActionEvent event) {
        controller.deleteUser(controller.getCurrentUser());
        ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);

	}
}
