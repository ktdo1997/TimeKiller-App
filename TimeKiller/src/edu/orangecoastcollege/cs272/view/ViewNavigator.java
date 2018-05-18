package edu.orangecoastcollege.cs272.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewNavigator
{
    public static final String SIGN_UP_SCENE = "SignUpScene.fxml";
    public static final String SIGN_IN_SCENE = "SignInScene.fxml";
    public static final String FORGOT_ACCOUNT_SCENE = "ForgotAccountScene.fxml";
    public static final String GUESSING_GAME_SCENE = "GuessingGameScene.fxml";
    public static final String MAIN_MENU = "MainMenu.fxml";
    public static final String GAME_SCENE = "GameScene.fxml";
    public static final String ACCOUNT_SCENE = "AccountScene.fxml";
    public static final String PROFILE_SCENE = "ProfileScene.fxml";
    public static final String EMAIL_SCENE = "EmailScene.fxml";
    public static final String USERNAME_SCENE = "UsernameScene.fxml";
    public static final String PASSWORD_SCENE = "PasswordScene.fxml";
    public static final String QUIZ_SCENE = "QuizScene.fxml";
    public static final String USER_QUIZ_SCORE_SCENE = "UserQuizScoreScene.fxml";
    public static final String USER_DICE_SCORE_SCENE = "UserDiceScoreScene.fxml";
    public static final String USER_GUESSING_SCORE_SCENE = "UserGuessingScoreScene.fxml";

    public static Stage mainStage;


    public static void setStage(Stage stage)
    {
        mainStage = stage;
    }

    public static void loadScene(String title, String sceneFXML)
    {

        try
        {
            mainStage.setTitle(title);
            Scene scene = new Scene(FXMLLoader.load(ViewNavigator.class.getResource(sceneFXML)));
            mainStage.setScene(scene);
            mainStage.show();
        }
        catch (IOException e)
        {
            System.err.println("Error loading: " + sceneFXML + "\n" + e.getMessage());
            e.printStackTrace();
        }
    }

}
