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
	    String userGuess = yourGuessTF.getText();
	    String userBet = yourBetTF.getText();
	    int userPoint = Integer.parseInt(yourPointLabel.getText());
	    int enemyPoint = Integer.parseInt(botPointsLabel.getText());
	    if(controller.isValidGuessAndBet(yourGuessTF.getText()) == false)
            guessErrorLabel.setVisible(true);
        if(controller.isValidGuessAndBet(yourBetTF.getText()) == false)
            betErrorLabel.setVisible(true);
        diceRollLabel.setText(String.valueOf(controller.getDice()));
        if(controller.diceGame(userGuess) == 1)
        {
            userPoint += Integer.parseInt(userBet);
            enemyPoint -= Integer.parseInt(userBet);
        }
        else
        {
            userPoint -= Integer.parseInt(userBet);
            enemyPoint += Integer.parseInt(userBet);
        }
        yourPointLabel.setText(String.valueOf(userPoint));
        botPointsLabel.setText(String.valueOf(enemyPoint));

        controller.printList();
        }

}
