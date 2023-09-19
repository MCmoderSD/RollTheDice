import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {
    private Boolean[][] diceArray;
    public DicePanel(Dice dice) {
        super();
        diceRolled(dice);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.black);

        if (diceArray[0][0]) g.fillOval(25, 25, 50, 50);
        if (diceArray[0][2]) g.fillOval(175, 25, 50, 50);
        if (diceArray[1][0]) g.fillOval(25, 100, 50, 50);
        if (diceArray[1][1]) g.fillOval(100, 100, 50, 50);
        if (diceArray[1][2]) g.fillOval(175, 100, 50, 50);
        if (diceArray[2][0]) g.fillOval(25, 175, 50, 50);
        if (diceArray[2][2]) g.fillOval(175, 175, 50, 50);
    }

    public void diceRolled(Dice dice) {
        diceArray = dice.getArray();
        repaint();
    }
}
