package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SignInScene
{
    private static Controller controller = Controller.getInstance();

    @FXML
    private TextField iDTF;
    @FXML
    private TextField passwordTF;
    @FXML
    private Label iDErrorLabel;
    @FXML
    private Label passwordErrorLabel;
    @FXML
    private Label signInErrorLabel;

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
            ViewNavigator.loadScene("Video Game List", ViewNavigator.MAIN_MENU);
            return true;
        }
        signInErrorLabel.setText(result);
        signInErrorLabel.setVisible(true);
        return false;
    }

    @FXML
    public void loadSignUp(MouseEvent event)
    {
        ViewNavigator.loadScene("Sign Up", ViewNavigator.SIGN_UP_SCENE);
    }

    public void loadForgetID(MouseEvent event)
    {
       // ViewNavigator.loadScene("Forget ID/Password", ViewNavigator);
    }
    public void loadGuest(MouseEvent event)
    {
        //ViewNavigator.loadScene("Guest", ViewNavigator);

    }

}
