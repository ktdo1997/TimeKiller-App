package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignInScene {
    private static Controller controller = Controller.getInstance();

	@FXML
	private Label signInErrorLabel;
	@FXML
	private PasswordField passwordTF;
	@FXML
	private TextField iDTF;
	@FXML
	private Label iDErrorLabel;
	@FXML
	private Label passwordErrorLabel;
	@FXML
	public boolean signIn() {
        // Get user info
        String iD = iDTF.getText();
        String password = passwordTF.getText();

        //Show errors
        iDErrorLabel.setVisible(iD.isEmpty());
        passwordErrorLabel.setVisible(password.isEmpty());

        if (iDErrorLabel.isVisible() || passwordErrorLabel.isVisible())
            return false;

        // Let's try to sign the user in (store the result)
        String result = controller.signInUser(iD, password);
        if (result.equalsIgnoreCase("SUCCESS")) {
            signInErrorLabel.setVisible(false);
            ViewNavigator.loadScene("TimeKiller App", ViewNavigator.MAIN_MENU);
            return true;
        }
        signInErrorLabel.setText(result);
        signInErrorLabel.setVisible(true);
        return false;
    }
	// Event Listener on Button.onAction
	//@FXML
	/*public void loadGuest(ActionEvent event) {
        ViewNavigator.loadScene("TimeKiller App", ViewNavigator.MAIN_MENU);

	}*/
	// Event Listener on Button.onAction

	// Event Listener on Label.onMouseClicked
	@FXML
	public void loadForgotAccount(MouseEvent event) {
	    ViewNavigator.loadScene("Forgot Account", ViewNavigator.FORGOT_ACCOUNT_SCENE);
    }

	// Event Listener on Label.onMouseClicked
	@FXML
	public void loadSignUp(MouseEvent event) {
	    ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
	}
}
