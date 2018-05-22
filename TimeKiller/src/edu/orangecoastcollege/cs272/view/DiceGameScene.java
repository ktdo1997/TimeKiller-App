package edu.orangecoastcollege.cs272.view;

import edu.orangecoastcollege.cs272.controller.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DiceGameScene {
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
	    diceRollLabel.setText(String.valueOf(controller.getDice()));
	    if(controller.isValidGuessAndBet(String.valueOf(userGuess)) == false)
            guessErrorLabel.setVisible(true);
        if(controller.isValidGuessAndBet(String.valueOf(userBet)) == false)
            betErrorLabel.setVisible(true);
        if(controller.diceGame(String.valueOf(userGuess)) == 1)
        {
            userPoint += userBet;
            enemyPoint -= userBet;
        }
        else
        {
            userPoint -= userBet;
            enemyPoint += userBet;
        }
        yourPointLabel.setText(String.valueOf(userPoint));
        botPointsLabel.setText(String.valueOf(enemyPoint));        }

}
