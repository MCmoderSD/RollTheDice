import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private final JLabel diceLabel;

    public GUI(Controller controller, Dice dice, String[] args) {
        super("Roll The Dice");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(null);
        controlPanel.setPreferredSize(new Dimension(300, 200));
        add(controlPanel, BorderLayout.NORTH);
        pack();

        // Dice Panel
        DicePanel dicePanel = new DicePanel(dice);
        dicePanel.setPreferredSize(new Dimension(250, 250));
        dicePanel.setLayout(null);
        pack();

        // Button
        JButton bRoll = new JButton("Roll The Dice");
        int bRollWidth = Math.toIntExact(Math.round(controlPanel.getWidth() * 0.6));
        int bRollHeight = Math.toIntExact(Math.round(controlPanel.getHeight() * 0.2));
        int bRollX = (controlPanel.getWidth() - bRollWidth) / 2;
        int bRollY = (controlPanel.getHeight() - bRollHeight) / 4;
        Font bRollFont = new Font("Roboto", Font.PLAIN, Math.toIntExact(Math.round(bRollHeight * 0.6)));
        bRoll.setFont(bRollFont);
        bRoll.setBounds(bRollX, bRollY, bRollWidth, bRollHeight);
        bRoll.addActionListener(e -> controller.buttonPressed(dicePanel));
        controlPanel.add(bRoll);

        // Dice Label
        diceLabel = new JLabel("Dice: " + dice.getValue());
        int diceLabelWidth = Math.toIntExact(Math.round(controlPanel.getWidth() * 0.6));
        int diceLabelHeight = Math.toIntExact(Math.round(controlPanel.getHeight() * 0.2));
        int diceLabelX = (controlPanel.getWidth() - diceLabelWidth) / 2;
        int diceLabelY = (controlPanel.getHeight() - diceLabelHeight) / 3 * 2;
        Font diceLabelFont = new Font("Roboto", Font.PLAIN, Math.toIntExact(Math.round(diceLabelHeight * 0.6)));
        diceLabel.setFont(diceLabelFont);
        diceLabel.setBounds(diceLabelX, diceLabelY, diceLabelWidth, diceLabelHeight);
        controlPanel.add(diceLabel);

        // Mode Selection
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (args.length == 0) {
            add(dicePanel, BorderLayout.CENTER);
            pack();
            dicePanel.setConfiguration(dicePanel.getWidth(), dicePanel.getHeight());
            setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
            setVisible(true);
        } else if (args[0].equals("dual")) {
            JFrame frame = new JFrame();
            frame.setTitle("Dice");
            frame.setResizable(false);
            frame.add(dicePanel);
            frame.pack();

            dicePanel.setConfiguration(dicePanel.getWidth(), dicePanel.getHeight());
            setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight() - frame.getHeight()) / 2);
            setVisible(true);

            frame.setLocation((screenSize.width - frame.getWidth()) / 2, getY() + getHeight());
            frame.setVisible(true);
        } else throw new IllegalArgumentException("Invalid argument: " + args[0]);
    }

    public void setDiceLabel(String text) {
        diceLabel.setText(text);
    }
}
