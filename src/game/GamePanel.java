package game;

import menu.MenuPanel;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import static utils.Constants.*;

public class GamePanel extends JPanel {
//    JFrame snakeFrame = (JFrame) SwingUtilities.getWindowAncestor(GamePanel.this);
    private GameTile[][] gameGrid = new GameTile[ROWS][COLS];
    private Snake snake = new Snake(new Point(ROWS / 2, COLS / 2));
    public GamePanel() {
        setLayout(new GridLayout(ROWS, COLS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        for (int ycor = 0; ycor < ROWS; ycor++) {
            for (int xcor = 0; xcor < COLS; xcor++) {
                GameTile tile = new GameTile(TILE_COLOR);
                gameGrid[xcor][ycor] = tile;
                add(tile);
            }
        }
    }
    public GameTile getTile(int row, int col) {
        return gameGrid[col][row];
    }
    private void paintGame() {
        for (int ycor = 0; ycor < ROWS; ycor++) {
            for (int xcor = 0; xcor < COLS; xcor++) {
                Color pointColor = TILE_COLOR;
                Point currentPoint = new Point(xcor, ycor);
                for (Point snakePoint : snake.getBody()) {
                    if (currentPoint.equals(snakePoint)) {
                        System.out.println(currentPoint.toString() + "  " + snakePoint.toString());
                        if (currentPoint.equals(snake.getHead())) {
                            pointColor = HEAD_COLOR;
                        } else {
                            pointColor = BODY_COLOR;
                        }
                    }
                }
                gameGrid[xcor][ycor].setColor(pointColor);
            }
        }
        repaint();
    }
    public void startGame() {
        // start timers etc.
        System.out.println("Game started");
        paintGame();
        Timer moveTimer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                snake.move();
                paintGame();
            }
        };
        moveTimer.scheduleAtFixedRate(task, 0, 400);
    }
    public void updateSnakeDirection(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP -> snake.setDirection(Constants.Direction.UP);
            case KeyEvent.VK_DOWN -> snake.setDirection(Constants.Direction.DOWN);
            case KeyEvent.VK_RIGHT -> snake.setDirection(Constants.Direction.RIGHT);
            case KeyEvent.VK_LEFT -> snake.setDirection(Constants.Direction.LEFT);
        }
    }
}
