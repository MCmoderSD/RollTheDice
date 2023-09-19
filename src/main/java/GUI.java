import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private DicePanel dicePanel;
    private JLabel diceLabel;
    public GUI(Controller controller, Dice dice) {
        initFrame(dice);
        initComponents(controller);
    }

    private void initComponents(Controller controller) {
        Font font = new Font("Roboto", Font.BOLD, 18);

        JButton rollButton = new JButton("Roll The Dice");

        int width = Math.toIntExact(Math.round(getWidth() * (0.6)));
        int height = Math.toIntExact(Math.round(getHeight() * (0.15)));

        rollButton.setBounds((getWidth()-width) / 2, (getHeight()-height) /4, width, height);
        rollButton.setFont(font);
        rollButton.addActionListener(e -> controller.buttonPressed(dicePanel));
        add(rollButton);

        diceLabel = new JLabel("Dice: ");
        diceLabel.setBounds((getWidth()-width) / 2, ((getHeight()-height) /4)*2, width, height);
        diceLabel.setFont(font);
        add(diceLabel);
    }

    private void initFrame(Dice dice) {
        setTitle("Roll The Dice");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();



        JFrame diceFrame = new JFrame("Dice");
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);

        dicePanel = new DicePanel(dice);
        dicePanel.setPreferredSize(new Dimension(250, 250));
        diceFrame.add(dicePanel);
        diceFrame.pack();


        int x = ((screenSize.width - this.getWidth()) / 2);
        int y = ((screenSize.height - this.getHeight() - diceFrame.getHeight()) / 2);

        setLocation(x, y);
        setVisible(true);


        x = ((screenSize.width - diceFrame.getWidth()) / 2);
        y = y + this.getHeight();

        diceFrame.setLocation(x, y);
        diceFrame.setVisible(true);
    }

    public void setDiceLabel(String text) {
        diceLabel.setText(text);
    }
}
