import javax.swing.*;
import java.awt.*;

public class DicePanel extends JPanel {
    private boolean isConfigured = false;
    private int radius;
    private int margin;
    private int size;
    private int offsetX, offsetY;
    private Boolean[][] diceArray;

    // Constructor
    public DicePanel(Dice dice) {
        super();
        diceArray = dice.getArray();
    }

    // Sets the configuration of the dice panel
    public void setConfiguration(int parentWidth, int parentHeight) {
        int windowSize = Math.min(parentWidth, parentHeight);

        offsetX = (parentWidth - windowSize) / 2;
        offsetY = (parentHeight - windowSize) / 2;

        radius = Math.toIntExact(Math.round(windowSize * 0.2));
        margin = Math.toIntExact(Math.round(windowSize * 0.1));
        size = radius + margin;

        isConfigured = true;
    }

    // Paints the dice panel
    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.black);

        // Left Row
        if (diceArray[0][0]) g.fillOval(offsetX + margin, offsetY + margin, radius, radius); // Top
        if (diceArray[1][0]) g.fillOval(offsetX + margin, offsetY + size + margin, radius, radius); // Middle
        if (diceArray[2][0]) g.fillOval(offsetX + margin, offsetY + 2 * size + margin, radius, radius); // Bottom

        // Middle Row
        if (diceArray[0][1]) g.fillOval(offsetX + size + margin, offsetY + margin, radius, radius); // Top
        if (diceArray[1][1]) g.fillOval(offsetX + size + margin, offsetY + size + margin, radius, radius); // Middle
        if (diceArray[2][1]) g.fillOval(offsetX + size + margin, offsetY + 2 * size + margin, radius, radius); // Bottom

        // Right Row
        if (diceArray[0][2]) g.fillOval(offsetX + 2 * size + margin, offsetY + margin, radius, radius); // Top
        if (diceArray[1][2]) g.fillOval(offsetX + 2 * size + margin, offsetY + size + margin, radius, radius); // Middle
        if (diceArray[2][2]) g.fillOval(offsetX + 2 * size + margin, offsetY + 2 * size + margin, radius, radius); // Bottom
    }

    // Called when the dice is rolled
    public void diceRolled(Dice dice) {
        if (!isConfigured) throw new IllegalStateException("DicePanel is not configured");
        diceArray = dice.getArray();
        repaint();
    }
}
