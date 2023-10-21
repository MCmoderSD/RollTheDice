package de.MCmoderSD.data;

public class Dice {

    // Default if there is no valid value
    private final Boolean[][] none = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
    };

    // Hardcoded 2D array for one
    private final Boolean[][] one = {
            {false, false, false},
            {false, true, false},
            {false, false, false}
    };

    // Hardcoded 2D array for two
    private final Boolean[][] two = {
            {false, false, true},
            {false, false, false},
            {true, false, false}
    };

    // Hardcoded 2D array for three
    private final Boolean[][] three = {
            {false, false, true},
            {false, true, false},
            {true, false, false}
    };

    // Hardcoded 2D array for four
    private final Boolean[][] four = {
            {true, false, true},
            {false, false, false},
            {true, false, true}
    };

    // Hardcoded 2D array for five
    private final Boolean[][] five = {
            {true, false, true},
            {false, true, false},
            {true, false, true}
    };

    // Hardcoded 2D array for six
    private final Boolean[][] six = {
            {true, false, true},
            {true, false, true},
            {true, false, true}
    };

    // Value of the dice
    private byte value;

    // Constructor initializes value to 0
    public Dice() {
        value = 0;
    }

    // Getter and setter for value
    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        if (value >= 1 && value <= 6) this.value = value;
    }

    @SuppressWarnings("unused") // Rolls the dice
    public void roll() {
        value = (byte) ((Math.random() * 6) + 1);
    }

    // Returns the 2D array for the current value
    public Boolean[][] getArray() {
        switch (value) {
            case 1:
                return one;
            case 2:
                return two;
            case 3:
                return three;
            case 4:
                return four;
            case 5:
                return five;
            case 6:
                return six;
            default:
                return none;
        }
    }
}
