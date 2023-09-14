public class Controller {

    private GUI gui;
    private Dice dice;

    public static void main(String[] args) {
        new Controller().init();
    }

    public void buttonPressed() {
        dice.roll();
        gui.setDiceLabel("Dice: " + dice.getValue());
    }

    private void init() {
        dice = new Dice();
        gui = new GUI(this);
    }
}
