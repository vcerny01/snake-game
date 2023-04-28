package game;

import java.util.ArrayList;
import java.awt.Point;
import static utils.Constants.*;
public class Snake {

    private Direction direction;
    private ArrayList<Point> body = new ArrayList<>();

    public Snake(Point headPosition) {
        body.add(headPosition);
        body.add(new Point(headPosition.x - 1, headPosition.y));
        body.add(new Point(headPosition.x - 2, headPosition.y));
        direction = Direction.RIGHT;
    }
    public void move() {
        Point head = getNewHead();
        switch (head.x) {
            case ROWS -> head.x = 0;
            case -1 -> head.x = ROWS - 1;
        }
        switch (head.y) {
            case COLS -> head.y = 0;
            case -1 -> head.y = COLS - 1;
        }
        System.out.println(head.x);
        body.add(0, head);
        body.remove(body.size() - 1);
        System.out.println("POINTS: " + getBody().toString());
    }
    public boolean isCollisionWith(Point point) {
        for (Point bodyPart : body) {
            if (bodyPart.equals(point)) {
                return true;
            }
        }
        return false;
    }
    public Direction getDirection() {
        return this.direction;
    }
    public void setDirection(Direction direction) {
        System.out.println("Direction changed");
        Direction currentDirection = getDirection();
        if ((direction.ordinal() % 2) != (currentDirection.ordinal() % 2)) {
            this.direction = direction;
        }
    }
    private Point getNewHead() {
        Point head = new Point(getHead());
        switch (direction) {
            case UP -> head.y--;
            case DOWN -> head.y++;
            case LEFT -> head.x--;
            case RIGHT -> head.x++;
        }
        return head;
    }
    public Point getHead() {
        return body.get(0);
    }
    public ArrayList<Point> getBody() {
        return body;
    }
}