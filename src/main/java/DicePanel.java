import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {
    private boolean isConfigured = false;
    private int r;
    private int margin;
    private int size;
    private int offsetX, offsetY;
    private Boolean[][] diceArray;
    public DicePanel(Dice dice) {
        super();
        diceArray = dice.getArray();
    }

    public void setConfiguration(int parentWidth, int parentHeight) {
        int windowSize = (parentWidth + parentHeight) / 2;

        // ToDo Offset
        offsetX = (parentWidth - windowSize) / 2;
        offsetY = (parentHeight - windowSize) / 2;

        r = Math.toIntExact(Math.round(windowSize * 0.2));
        margin = Math.toIntExact(Math.round(windowSize * 0.1));
        size = r + margin;

        isConfigured = true;
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.black);

            if (diceArray[0][0]) g.fillOval(offsetX + margin, offsetY + margin, r, r);
            if (diceArray[0][2]) g.fillOval(offsetX + 2 * size + margin,offsetY + margin, r, r);
            if (diceArray[1][0]) g.fillOval(offsetX + margin,offsetY + size + margin, r, r);
            if (diceArray[1][1]) g.fillOval(offsetX + size + margin,offsetY + size + margin, r, r);
            if (diceArray[1][2]) g.fillOval(offsetX + 2 * size + margin,offsetY + size + margin, r, r);
            if (diceArray[2][0]) g.fillOval(offsetX + margin,offsetY + 2 * size + margin, r, r);
            if (diceArray[2][2]) g.fillOval(offsetX + 2 * size + margin,offsetY + 2 * size + margin, r, r);
    }

    public void diceRolled(Dice dice) {
        if (!isConfigured) throw new IllegalStateException("DicePanel is not configured");
        diceArray = dice.getArray();
        repaint();
    }
}
