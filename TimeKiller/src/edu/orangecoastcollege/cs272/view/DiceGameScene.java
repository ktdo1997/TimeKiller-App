package edu.orangecoastcollege.cs272.view;

import java.net.URL;
import java.util.ResourceBundle;

import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DiceGameScene implements Initializable{
	private int playerPoints;
	private int enemyPoints;
	private static Controller controller = Controller.getInstance();

    @FXML
	private TextField yourBetTF;
	@FXML
	private Label yourPointLabel;
	@FXML
	private Label botBetLabel;
	@FXML
	private Label botPointsLabel;
	@FXML
	private Label betErrorLabel;
	@FXML
	private Label diceRollLabel;
	@FXML
	private TextField yourGuessTF;
	@FXML
	private Label guessErrorLabel;

	// Event Listener on Button.onAction
	@FXML
	public void loadGameScene(ActionEvent event) {
	    ViewNavigator.loadScene("Game", ViewNavigator.GAME_SCENE);
	}
	// Event Listener on Button.onAction
	@FXML
	public void playDiceGame(ActionEvent event) {
	    int userGuess = Integer.parseInt(yourGuessTF.getText());
	    int userBet = Integer.parseInt(yourBetTF.getText());
	    int userPoint = Integer.parseInt(yourPointLabel.getText());
	    int enemyPoint = Integer.parseInt(botPointsLabel.getText());
        guessErrorLabel.setVisible(false);
        betErrorLabel.setVisible(false);
	    if(controller.isValidGuessAndBet(String.valueOf(userGuess)) == false)
	        guessErrorLabel.setVisible(true);
	    if(controller.isValidGuessAndBet(String.valueOf(userBet)) == false)
            betErrorLabel.setVisible(true);

	    if(controller.diceGame(String.valueOf(userGuess)) == 1)
	    {
	        userPoint += userBet;
	        enemyPoint -= userBet;
	    }

	}
    @Override
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        playerPoints = 100;
        enemyPoints = 100;
        yourPointLabel.setText(String.valueOf(playerPoints));
        botPointsLabel.setText(String.valueOf(enemyPoints));

    }
}
