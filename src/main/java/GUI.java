import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GUI extends JFrame {

    // GUI class is responsible for the graphical user interface of the program.
    private final JLabel leftDiceLabel; // Label that displays the value of the dice.
    private final JLabel rightDiceLabel; // Label that displays the value of the right dice.
    private final DicePanel leftDicePanel; // Panel that displays the left dice.
    private final DicePanel rightDicePanel; // Panel that displays the right dice.

    // Constructor
    public GUI(Controller controller, Dice leftDice, Dice rightDice, String[] args) {
        // JFrame
        super("Roll The Dice");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // Control Panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(null);
        controlPanel.setPreferredSize(new Dimension(300, 200));
        add(controlPanel, BorderLayout.CENTER);
        pack();

        ArrayList<DicePanel> dicePanels = new ArrayList<>();
        dicePanels.add(leftDicePanel = new DicePanel(leftDice));
        dicePanels.add(rightDicePanel = new DicePanel(rightDice));

        for (DicePanel dicePanel : dicePanels) {
            dicePanel.setPreferredSize(new Dimension(300, 300));
            dicePanel.setConfiguration(dicePanel.getWidth(), dicePanel.getHeight());
        }

        // Button
        JButton bRoll = new JButton("Roll The Dice");
        int bRollWidth = Math.toIntExact(Math.round(controlPanel.getWidth() * 0.6));
        int bRollHeight = Math.toIntExact(Math.round(controlPanel.getHeight() * 0.2));
        int bRollX = (controlPanel.getWidth() - bRollWidth) / 2;
        int bRollY = (controlPanel.getHeight() - bRollHeight) / 4;
        Font bRollFont = new Font("Roboto", Font.PLAIN, Math.toIntExact(Math.round(bRollHeight * 0.6)));
        bRoll.setFont(bRollFont);
        bRoll.setBounds(bRollX, bRollY, bRollWidth, bRollHeight);
        bRoll.addActionListener(e -> controller.buttonPressed(leftDicePanel, rightDicePanel));
        controlPanel.add(bRoll);

        // Dice Label
        ArrayList<JLabel> diceLabels = new ArrayList<>();
        diceLabels.add(leftDiceLabel = new JLabel());
        diceLabels.add(rightDiceLabel = new JLabel());

        int diceLabelWidth = Math.toIntExact(Math.round(controlPanel.getWidth() * 0.6));
        int diceLabelHeight = Math.toIntExact(Math.round(controlPanel.getHeight() * 0.2));
        int diceLabelX = (controlPanel.getWidth() - diceLabelWidth) / 2;
        int diceLabelY = (controlPanel.getHeight() - diceLabelHeight) / 3 * 2;

        Font diceLabelFont = new Font("Roboto", Font.PLAIN, Math.toIntExact(Math.round(diceLabelHeight * 0.6)));

        for (JLabel diceLabel : diceLabels) {
            diceLabel.setFont(diceLabelFont);
            diceLabel.setBounds(diceLabelX, diceLabelY, diceLabelWidth, diceLabelHeight);
            diceLabel.setHorizontalAlignment(SwingConstants.CENTER);
            controlPanel.add(diceLabel);
        }

        diceLabels.get(1).setLocation(diceLabelX, diceLabelY + diceLabelHeight);


        // Mode Selection
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (args.length == 0) { // Default mode
            add(leftDicePanel, BorderLayout.WEST);
            add(rightDicePanel, BorderLayout.EAST);
            pack();
            leftDicePanel.setConfiguration(leftDicePanel.getWidth(), leftDicePanel.getHeight());
            rightDicePanel.setConfiguration(rightDicePanel.getWidth(), rightDicePanel.getHeight());
            setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
            setVisible(true);
        } else if (args[0].equals("dual")) { // Dual mode
            ArrayList<JFrame> frames = new ArrayList<>();
            frames.add(new JFrame("Left Dice"));
            frames.add(new JFrame("Right Dice"));
            frames.get(0).add(leftDicePanel);
            frames.get(1).add(rightDicePanel);

            for (JFrame frame : frames) {
                frame.setResizable(false);
                frame.pack();
            }

            leftDicePanel.setConfiguration(leftDicePanel.getWidth(), leftDicePanel.getHeight());
            rightDicePanel.setConfiguration(rightDicePanel.getWidth(), rightDicePanel.getHeight());

            frames.get(0).setLocation((screenSize.width - getWidth()) / 2 - frames.get(0).getWidth(), (screenSize.height - frames.get(0).getHeight()) / 2);
            frames.get(1).setLocation((screenSize.width - getWidth()) / 2 + getWidth(), (screenSize.height - frames.get(1).getHeight()) / 2);
            frames.add(this);
            setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
            for (JFrame frame : frames) frame.setVisible(true);
        } else throw new IllegalArgumentException("Invalid argument: " + args[0]);

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) controller.buttonPressed(leftDicePanel, rightDicePanel);
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        requestFocusInWindow();
    }

    // Set the text of the dice label.
    public void setDiceLabels(String leftDiceText, String rightDiceText) {
        leftDiceLabel.setText(leftDiceText);
        rightDiceLabel.setText(rightDiceText);
    }

    // Show a message dialog when the user gets doublets.
    public void doublets(byte leftDiceValue) {
        JOptionPane.showMessageDialog(this, "You got " + leftDiceValue + " on both dice!", "Doublets!!!", JOptionPane.INFORMATION_MESSAGE);
    }
}
