public class Dice {
    private byte value;
    public Dice() {
        roll();
    }

    public byte getValue() {
        return value;
    }

    public void roll() {
        value = (byte) ((Math.random() * 6) + 1);
    }
}
