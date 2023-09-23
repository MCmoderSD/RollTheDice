public class Controller {

    // Associations
    private GUI gui;
    private Dice dice;

    // Initializes the GUI and the Dice
    private void init(String[] args) {
        dice = new Dice();
        gui = new GUI(this, dice, args);
    }

    // Called when the button is pressed
    public void buttonPressed(DicePanel dicePanel) {
        rollDice();
        gui.setDiceLabel("Dice: " + dice.getValue());
        dicePanel.diceRolled(dice);
    }

    // Rolls the dice
    public void rollDice() {
        byte value = (byte) ((Math.random() * 6) + 1);
        dice.setValue(value);
    }

    // Main method
    public static void main(String[] args) {
        new Controller().init(args);
    }
}
