import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    private DicePanel dicePanel;
    private JLabel diceLabel;
    public GUI(Controller controller, Dice dice) {
        initComponents(controller, dice);
    }

    private void initComponents(Controller controller, Dice dice) {
        Font font = new Font("Roboto", Font.BOLD, 18);

        JButton rollButton = new JButton("Roll The Dice");

        int width = Math.toIntExact(Math.round(getWidth() * (0.6)));
        int height = Math.toIntExact(Math.round(getHeight() * (0.15)));

        rollButton.setBounds((getWidth()-width) / 2, (getHeight()-height) /4, width, height);
        rollButton.setFont(font);
        rollButton.addActionListener(e -> controller.buttonPressed(dicePanel));

        JPanel contentPanel = new JPanel();
        contentPanel.setPreferredSize(new Dimension(300,200));
        contentPanel.add(rollButton);
        contentPanel.setLayout(null);

        diceLabel = new JLabel("Dice: ");
        diceLabel.setBounds((getWidth()-width) / 2, ((getHeight()-height) /4)*2, width, height);
        diceLabel.setFont(font);
        contentPanel.add(diceLabel);



        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        dicePanel = new DicePanel(dice);
        dicePanel.setPreferredSize(new Dimension(250, 250));

        int x = ((screenSize.width - (200+250)) / 2);
        int y = ((screenSize.height - (300+250)) / 2);

        setLocation(x, y);
        Container cp = this.getContentPane();

        cp.add(contentPanel, BorderLayout.NORTH);
        cp.add(dicePanel, BorderLayout.CENTER);

        pack();
        Toolkit.getDefaultToolkit().sync();
        setVisible(true);
    }
    public void setDiceLabel(String text) {
        diceLabel.setText(text);
    }
}
