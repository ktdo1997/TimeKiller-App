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
    /*public void loadProfile(MouseEvent event)
    {
        //ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
    }
    public void loadAccount(MouseEvent event)
    {
        //ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
    }
    public void loadGame(MouseEvent event)
    {
        //ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
    }*/
}
