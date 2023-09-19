public class Dice {
    private final Boolean[][] none = {
            {false, false, false},
            {false, false, false},
            {false, false, false}
    };
    private final Boolean[][] one = {
            {false, false, false},
            {false, true, false},
            {false, false, false}
    };

    private final Boolean[][] two = {
            {false, false, true},
            {false, false, false},
            {true, false, false}
    };

    private final Boolean[][] three = {
            {false, false, true},
            {false, true, false},
            {true, false, false}
    };

    private final Boolean[][] four = {
            {true, false, true},
            {false, false, false},
            {true, false, true}
    };

    private final Boolean[][] five = {
            {true, false, true},
            {false, true, false},
            {true, false, true}
    };

    private final Boolean[][] six = {
            {true, false, true},
            {true, false, true},
            {true, false, true}
    };
    private byte value;

    public Dice() {
        value = 0;
    }

    public byte getValue() {
        return value;
    }

    public void roll() {
        value = (byte) ((Math.random() * 6) + 1);
    }

    public Boolean[][] getArray() {
        switch (value) {
            case 1: return one;
            case 2: return two;
            case 3: return three;
            case 4: return four;
            case 5: return five;
            case 6: return six;
            default: return none;
        }
    }
}
