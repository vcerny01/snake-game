import menu.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class SnakeFrame extends JFrame {
    JPanel menuPanel = new MenuPanel();
    SnakeFrame() {
        super("Snake Game in Java");
        setSize(500,500);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        add(menuPanel);
    }
}