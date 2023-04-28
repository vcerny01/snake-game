package menu;

import game.GamePanel;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuPanel extends JPanel {
    JButton startButton = new JButton("New Game");
    JButton exitButton = new JButton("Exit");
    HeaderText headerText = new HeaderText("SNAKE GAME", 42, this);
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
        *  exitButton.addActionListener(e -> System.exit(0));
         * */
        startButton.addActionListener(e -> newGame());
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Do you really want to exit the game?") == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });
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
    private void newGame() {
        JFrame snakeFrame = (JFrame) SwingUtilities.getWindowAncestor(MenuPanel.this);
        GamePanel gamePanel = new GamePanel();
        snakeFrame.getContentPane().removeAll();
        HeaderText pressEnterText = new HeaderText("Press ENTER to start the game", 30, gamePanel);
        pressEnterText.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        snakeFrame.getContentPane().add(pressEnterText);
        snakeFrame.getContentPane().add(gamePanel);
        snakeFrame.repaint();
        snakeFrame.setVisible(true);
        snakeFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    gamePanel.startGame();
                    snakeFrame.removeKeyListener(this);
                    snakeFrame.getContentPane().remove(0);
                    snakeFrame.repaint();
                }
            }
        });
        snakeFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                gamePanel.updateSnakeDirection(e);
            }
        });
        snakeFrame.setFocusable(true);
        snakeFrame.requestFocusInWindow();
    }
}