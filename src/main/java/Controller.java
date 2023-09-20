public class Controller {

    private GUI gui;
    private Dice dice;

    public static void main(String[] args) {
        new Controller().init(args);
    }

    public void buttonPressed(DicePanel dicePanel) {
        gui.setDiceLabel("Dice: " + dice.getValue());
        rollDice();
        dicePanel.diceRolled(dice);
    }

    public void rollDice() {
        byte value = (byte) ((Math.random() * 6) + 1);
        dice.setValue(value);
    }

    private void init(String[] args) {
        dice = new Dice();
        gui = new GUI(this, dice, args);
    }
}
