package game;

import menu.MenuPanel;
import utils.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import static utils.Constants.*;

public class GamePanel extends JPanel {
//    JFrame snakeFrame = (JFrame) SwingUtilities.getWindowAncestor(GamePanel.this);
    private GameTile[][] gameGrid = new GameTile[ROWS][COLS];
    private Snake snake = new Snake(new Point(ROWS / 2, COLS / 2));
    private ArrayList<Food> foodObjects = new ArrayList<Food>();
    private int allMoves;
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
                for (Food food : foodObjects) {
                    if (currentPoint.equals(food.getPlace())) {
                        pointColor = food.getColor();
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
        TimerTask moveSnake = new TimerTask() {
            public void run() {
                allMoves++;
                snake.move();
                resolveSnakeFoodCollision();
                createFood();
                paintGame();
            }
        };
        moveTimer.scheduleAtFixedRate(moveSnake, 0, 200);
    }
    public void updateSnakeDirection(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP -> snake.setNextDirection(Constants.Direction.UP);
            case KeyEvent.VK_DOWN -> snake.setNextDirection(Constants.Direction.DOWN);
            case KeyEvent.VK_RIGHT -> snake.setNextDirection(Constants.Direction.RIGHT);
            case KeyEvent.VK_LEFT -> snake.setNextDirection(Constants.Direction.LEFT);
        }
    }
    public void createFood(){
        if ((allMoves % BasicFood.expirationMoves) == 0){
            foodObjects.removeIf(food -> food instanceof BasicFood);
            if ((allMoves % BasicFood.recurrenceMoves) == 0) {
                BasicFood basicFood = new BasicFood(snake.getBody());
                foodObjects.add(basicFood);
            }
        }
    }
    public void resolveSnakeFoodCollision() {
        for (Food food : foodObjects) {
            if (food.getPlace().equals(snake.getHead())) {
                snake.extendBody();
                // add exp
                foodObjects.remove(food);
                break;
            }
        }

    }
}
