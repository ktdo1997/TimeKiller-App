package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SignUpScene {

    private static Controller controller = Controller.getInstance();

    @FXML
    private TextField UserIDTF;

    @FXML
    private Label idErrorLabel;

    @FXML
    private TextField emailAddressTF;

    @FXML
    private Label emailErrorLabel;

    @FXML
    private TextField passwordTF;

    @FXML
    private Label passwordErrorLabel;

    @FXML
    private Label signUpErrorLabel;

    @FXML
    public boolean signUp() {
        String name = UserIDTF.getText();
        String email = emailAddressTF.getText();
        String password = passwordTF.getText();

        idErrorLabel.setVisible(name.isEmpty());
        emailErrorLabel.setVisible(email.isEmpty());
        passwordErrorLabel.setVisible(password.isEmpty());

        if (idErrorLabel.isVisible() || emailErrorLabel.isVisible() || passwordErrorLabel.isVisible())
            return false;

        String result = controller.signUpUser(name, email, password);
        if (result.equalsIgnoreCase("SUCCESS")) {
            signUpErrorLabel.setVisible(false);
            ViewNavigator.loadScene("Time Killer", ViewNavigator.MAIN_MENU);
            return true;
        }
        signUpErrorLabel.setText(result);
        signUpErrorLabel.setVisible(true);
        return false;
    }
    public Object loadSignIn()
    {
        ViewNavigator.loadScene("Sign In", ViewNavigator.SIGN_IN_SCENE);
        return this;
    }
}
