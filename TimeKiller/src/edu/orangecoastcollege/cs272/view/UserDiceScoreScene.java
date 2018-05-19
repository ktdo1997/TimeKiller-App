package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.scene.control.Label;

public class UserDiceScoreScene implements Initializable{
	private static Controller controller = Controller.getInstance();
	@FXML
	private Label currentUserNameLabel;
	@FXML
	private Label DiceScoreLabel;

	// Event Listener on Button.onAction
	@FXML
	public void backToAllGames()
	{
	    ViewNavigator.loadScene("Profile", ViewNavigator.PROFILE_SCENE);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		currentUserNameLabel.setText(controller.getCurrentUser().getUserName());
		
	}
}
