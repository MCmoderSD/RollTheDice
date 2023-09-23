import java.util.Objects;
import java.util.Random;

public class Controller {

    // Associations
    private GUI gui;
    private Dice leftDice, rightDice, dice;

    // Initializes the GUI and the Dice
    private void init(String[] args) {

        if(args.length == 0 || Objects.equals(args[0], "dual")) {
            leftDice = new Dice();
            rightDice = new Dice();
            gui = new GUI(this, leftDice, rightDice, args);
        } else if (Objects.equals(args[0], "noDoublets")) {
            dice = new Dice();
            gui = new GUI(this, dice, args);
        } else throw new IllegalArgumentException("Invalid arguments");

    }

    // Called when the button is pressed
    public void buttonPressed(DicePanel leftDicePanel, DicePanel rightDicePanel) {
        rollDice();

        leftDicePanel.diceRolled(leftDice);
        rightDicePanel.diceRolled(rightDice);

        if (leftDice.getValue() == rightDice.getValue()) gui.doublets(leftDice.getValue());
        else gui.setDiceLabels("Left Dice: " + leftDice.getValue(), "Right Dice: " + rightDice.getValue());
    }

    public void buttonPressed(DicePanel dicePanel) {
        rollDice();
        gui.setDiceLabel("Dice: " + dice.getValue());
        dicePanel.diceRolled(dice);
    }

    // Rolls the dice
    public void rollDice() {
        if (dice == null) {
            Random random = new Random();
            leftDice.setValue((byte) (random.nextInt(6) + 1));
            rightDice.setValue((byte) (random.nextInt(6) + 1));
        } else if (leftDice == null && rightDice == null) {
            dice.setValue((byte) (Math.random() * 6 + 1));
        } else throw new IllegalStateException("Invalid state");
    }

    // Main method
    public static void main(String[] args) {
        new Controller().init(args);
    }
}
