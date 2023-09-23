import java.util.Random;

public class Controller {

    // Associations
    private GUI gui;
    private Dice leftDice, rightDice;

    // Initializes the GUI and the Dice
    private void init(String[] args) {
        leftDice = new Dice();
        rightDice = new Dice();

        gui = new GUI(this, leftDice, rightDice, args);
    }

    // Called when the button is pressed
    public void buttonPressed(DicePanel leftDicePanel, DicePanel rightDicePanel) {
        rollDice();

        if (leftDice.getValue() == rightDice.getValue()) gui.doublets(leftDice.getValue());
        else gui.setDiceLabels("Left Dice: " + leftDice.getValue(), "Right Dice: " + rightDice.getValue());

        leftDicePanel.diceRolled(leftDice);
        rightDicePanel.diceRolled(rightDice);
    }

    // Rolls the dice
    public void rollDice() {
        Random random = new Random();
        leftDice.setValue((byte) (random.nextInt(6) + 1));
        rightDice.setValue((byte) (random.nextInt(6) + 1));
    }

    // Main method
    public static void main(String[] args) {
        new Controller().init(args);
    }
}
