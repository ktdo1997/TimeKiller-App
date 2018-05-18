package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class ForgotAccountScene {
    private static Controller controller = Controller.getInstance();

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
	    wrongEmailLabel.setVisible(false);
	    emailErrorLabel.setVisible(email.isEmpty());
	    if(emailErrorLabel.isVisible())
	        return false;
	    if(controller.getAccountInfo(email).length == 1)
	    {
	        wrongEmailLabel.setVisible(true);
    	    iDLabel.setText("");
            passwordLabel.setText("");
	    }
	    else
	    {
	        iDLabel.setText(String.valueOf(controller.getAccountInfo(email)[0]));
	        passwordLabel.setText(String.valueOf(controller.getAccountInfo(email)[1]));
	        return true;
	    }
	    return false;
	}
	// Event Listener on Button.onAction
	@FXML
	public void loadSignIn(ActionEvent event) {
	    ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);
	}
}
