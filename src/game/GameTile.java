package game;

import javax.swing.*;
import java.awt.*;

public class GameTile extends JPanel {
    private static final int TILE_SIZE = 15;
    private Color tileColor;
    public GameTile(Color color) {
        tileColor = color;
        setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
        setBackground(tileColor);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
    }

    public int getTileSize() {
        return TILE_SIZE;
    }
    public void setColor(Color color) {
        setBackground(color);
    }
    public Color getColor() {
        return tileColor;
    }
}
