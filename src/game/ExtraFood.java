package game;

import java.awt.*;
import java.util.ArrayList;

public class ExtraFood extends Food {
    public static final int expirationMoves = 40;
    public static final int recurrenceMoves = 50;
    public ExtraFood(ArrayList<Point> snakeBody, ArrayList<Food> foodObjects) {
        super(250, 4, Color.MAGENTA, snakeBody, foodObjects);
    }
}