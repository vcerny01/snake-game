package utils;

import java.awt.*;

public final class Constants {
    public final static int FRAME_WIDTH = 600;
    public final static int FRAME_HEIGHT = 600;
    public final static int ROWS = 30;
    public final static int COLS = 30;
    public static final int TILE_SIZE = 15;
    public static final Color TILE_COLOR = Color.BLUE;
    public static final Color HEAD_COLOR = Color.RED;
    public static final Color BODY_COLOR = Color.GREEN;
    public static enum Direction {
        UP, LEFT, DOWN, RIGHT;
    }
}