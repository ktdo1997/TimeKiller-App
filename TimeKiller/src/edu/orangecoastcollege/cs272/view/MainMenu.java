package edu.orangecoastcollege.cs272.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenu
{
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
