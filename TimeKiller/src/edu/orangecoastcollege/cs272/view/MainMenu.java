package edu.orangecoastcollege.cs272.view;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class MainMenu {
	@FXML
	private Button playGameBT;
	@FXML
	private Button accountBT;
	@FXML
	private Button profileBT;
	@FXML
	private Button logOutBT;
	@FXML
	private Label mainMenuLabel;

	// Event Listener on Button[#playGameBT].onAction
	@FXML
    public void loadSignIn(ActionEvent event)
    {
        ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);
    }
    public void loadGameScene(ActionEvent event)
    {
        ViewNavigator.loadScene("Game", ViewNavigator.GAME_SCENE);
    }
     public void loadAccountScene(ActionEvent event)
        {
            ViewNavigator.loadScene("My Account", ViewNavigator.ACCOUNT_SCENE);
        }
     public void loadProfileScene(ActionEvent event)
     {
         ViewNavigator.loadScene("My Profile", ViewNavigator.PROFILE_SCENE);
     }
}

