package game;

import java.awt.*;
import java.util.ArrayList;

public class BasicFood extends Food {
    public static final int expirationMoves = 25;
    public static final int recurrenceMoves = 30;

    public BasicFood(ArrayList<Point> snakeBody, ArrayList<Food> foodObjects) {
        super(100, 1, Color.YELLOW, snakeBody, foodObjects);
    }
}
