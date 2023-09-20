import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private final JLabel diceLabel;
    public GUI(Controller controller, Dice dice, String[] args) {
        setTitle("Roll The Dice");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        DicePanel dicePanel = new DicePanel(dice);
        dicePanel.setPreferredSize(new Dimension(250, 250));

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 300));
        add(panel);

        Font font = new Font("Roboto", Font.BOLD, 18);
        JButton rollButton = new JButton("Roll The Dice");

        int width = Math.toIntExact(Math.round(panel.getWidth() * (0.6)));
        int height = Math.toIntExact(Math.round(panel.getHeight() * (0.15)));

        rollButton.setBounds((panel.getWidth() - width) / 2, (panel.getHeight() - height) / 4, width, height);
        rollButton.setFont(font);
        rollButton.addActionListener(e -> controller.buttonPressed(dicePanel));
        panel.add(rollButton);

        diceLabel = new JLabel("Dice: ");
        diceLabel.setBounds((panel.getWidth() - width) / 2, ((panel.getHeight() - height) / 4) * 2, width, height);
        diceLabel.setFont(font);
        panel.add(diceLabel);

        if (args.length == 0) {
            add(panel, BorderLayout.NORTH);
            add(dicePanel, BorderLayout.CENTER);
            pack();
            setVisible(true);
        } else if (args[0].equals("dual")) {
            setLayout(null);
            JFrame diceFrame = new JFrame("Dice");

            diceFrame.add(dicePanel);
            diceFrame.setResizable(false);
            diceFrame.setLayout(null);
            diceFrame.pack();

            int x = ((screenSize.width - this.getWidth()) / 2);
            int y = ((screenSize.height - this.getHeight() - diceFrame.getHeight()) / 2);

            setLocation(x, y);
            setVisible(true);

            x = ((screenSize.width - diceFrame.getWidth()) / 2);
            y = y + this.getHeight();

            diceFrame.setLocation(x, y);
            diceFrame.setVisible(true);
            pack();
        } else throw new IllegalArgumentException("Invalid argument: " + args[0]);
    }

    public void setDiceLabel(String text) {
        diceLabel.setText(text);
    }
}
