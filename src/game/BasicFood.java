package game;

import java.awt.*;
import java.util.ArrayList;

public class BasicFood extends Food {
    public static final int expirationMoves = 15;
    public static final int recurrenceMoves = 40;

    public BasicFood(ArrayList<Point> snakeBody) {
        super(100, 1, Color.YELLOW, snakeBody);
    }
}
