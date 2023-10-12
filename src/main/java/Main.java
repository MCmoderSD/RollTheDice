import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        if(args.length == 0 || Objects.equals(args[0], "dual")) new Controller(new Dice(), new Dice(), args); // Dual dice
        else if (Objects.equals(args[0], "noDoublets")) new Controller(new Dice(), args); // Single dice
        else throw new IllegalArgumentException("Invalid arguments"); // Invalid arguments
    }
}
