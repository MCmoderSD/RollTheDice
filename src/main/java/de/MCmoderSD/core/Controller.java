package de.MCmoderSD.core;

import de.MCmoderSD.UI.DicePanel;
import de.MCmoderSD.UI.GUI;
import de.MCmoderSD.data.Dice;

import java.util.Random;

public class Controller {

    // Associations
    private final GUI gui;
    private final Dice dice, leftDice, rightDice;

    // Constructors

    // Single dice constructor
    public Controller(Dice dice, String[] args) {
        // Initialize associations
        this.dice = dice;
        leftDice = null;
        rightDice = null;

        // Initialize GUI
        gui = new GUI(this, dice, args);
    }

    // Dual dice constructor
    public Controller(Dice leftDice, Dice rightDice, String[] args) {
        // Initialize associations
        this.leftDice = leftDice;
        this.rightDice = rightDice;
        dice = null;

        // Initialize GUI
        gui = new GUI(this, leftDice, rightDice, args);
    }

    // Called when the button is pressed
    public void buttonPressed(DicePanel leftDicePanel, DicePanel rightDicePanel) {
        rollDice();

        leftDicePanel.diceRolled(leftDice);
        rightDicePanel.diceRolled(rightDice);

        assert leftDice != null;
        assert rightDice != null;
        if (leftDice.getValue() == rightDice.getValue()) gui.doublets(leftDice.getValue());
        else gui.setDiceLabels("Left Dice: " + leftDice.getValue(), "Right Dice: " + rightDice.getValue());
    }

    public void buttonPressed(DicePanel dicePanel) {
        rollDice();

        assert dice != null;

        gui.setDiceLabel("Dice: " + dice.getValue());
        dicePanel.diceRolled(dice);
    }

    // Rolls the dice
    public void rollDice() {
        if (dice == null) {
            Random random = new Random();

            assert leftDice != null;
            assert rightDice != null;

            leftDice.setValue((byte) (random.nextInt(6) + 1));
            rightDice.setValue((byte) (random.nextInt(6) + 1));
        } else if (leftDice == null && rightDice == null) {
            dice.setValue((byte) (Math.random() * 6 + 1));
        } else throw new IllegalStateException("Invalid state");
    }

}
