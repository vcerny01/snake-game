package game;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import static utils.Constants.COLS;
import static utils.Constants.ROWS;

public abstract class Food {
    private final int expGain;
    private final int newBlocks;
    private final Color color;
    public static int expirationMoves;
    public static int recurrenceMoves;
    private Point place;

    public Food(int expGain, int newBlocks, Color color, ArrayList<Point> snakeBody) {
        this.expGain = expGain;
        this.newBlocks = newBlocks;
        this.color = color;
        setRandomPlace(snakeBody);
    }
    public int getExpGain() {
        return this.expGain;
    }
    public int getNewBlocks() {
        return this.newBlocks;
    }
    public Color getColor() {
        return this.color;
    }
    public Point getPlace(){
        return place;
    }
    public void setRandomPlace(ArrayList<Point> snakeBody) {
        // ADD: check for conflicts with other foods
        while(true) {
            Random randomCol = new Random();
            Random randomRow = new Random();
            Point tempPoint = new Point( randomCol.nextInt(COLS), randomRow.nextInt(ROWS));
            if (!snakeBody.contains(tempPoint)) {
                this.place = tempPoint;
                break;
            }
        }
    }
}
