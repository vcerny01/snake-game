package menu;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    JButton startButton = new JButton("New Game");
    JButton exitButton = new JButton("Exit");
    HeaderText headerText = new HeaderText("SNAKE GAME", this);
    GameLogo gameLogo = new GameLogo("src/resources/snake-img.png");

    public MenuPanel() {
        headerText.setBorder(BorderFactory.createEmptyBorder(20,10,10,10));
        /*
        * 1.
        *  exitButton.addActionListener(this);
        * public void actionPerformed(ActionEvent event){
        *
        *
        *
        * button.addActionListener(new ActionListener() {
        *   public void actionPerformed(ActionEvent e) {
        *       System.out.println("Button clicked!");
        *   }
        *  });
        *
        * */
        exitButton.addActionListener(e -> System.exit(0));
        gameLogo.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        add(gameLogo);
        add(headerText);
        add(startButton);
        add(exitButton);
        for (Component component : this.getComponents()) {
            if (component instanceof JLabel || component instanceof JButton || component instanceof JTextField) {
                ((JComponent) component).setAlignmentX(Component.CENTER_ALIGNMENT);
            }
        }
    }
}