import menu.MenuPanel;
import static utils.Constants.*;
import javax.swing.*;
import java.awt.*;

public class SnakeFrame extends JFrame {
    JPanel menuPanel = new MenuPanel();
    SnakeFrame() {
        super("Snake Game in Java");
        setSize(FRAME_WIDTH,FRAME_HEIGHT);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        add(menuPanel);
    }
}