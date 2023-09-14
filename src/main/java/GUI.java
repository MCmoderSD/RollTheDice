import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private JLabel diceLabel;
    public GUI(Controller controller) {
        initFrame();
        initComponents(controller);
    }

    private void initComponents(Controller controller) {
        Font font = new Font("Roboto", Font.BOLD, 18);

        JButton rollButton = new JButton("Roll The Dice");
        int width = (int) (getWidth()*(0.6)), height = (int) (getHeight()*(0.15));
        rollButton.setBounds((getWidth()-width) / 2, (getHeight()-height) /4, width, height);
        rollButton.setFont(font);
        rollButton.addActionListener(e -> controller.buttonPressed());
        add(rollButton);

        diceLabel = new JLabel("Dice: ");
        diceLabel.setBounds((getWidth()-width) / 2, ((getHeight()-height) /4)*2, width, height);
        diceLabel.setFont(font);
        add(diceLabel);

    }

    private void initFrame() {
        setTitle("Roll The Dice");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Screen size
        int x = ((screenSize.width - this.getWidth()) / 2);
        int y = ((screenSize.height - this.getHeight()) / 2);
        setLocation(x, y);

        setVisible(true);
    }

    public void setDiceLabel(String text) {
        diceLabel.setText(text);
    }
}
