package game;

import java.util.ArrayList;
import java.awt.Point;
import static utils.Constants.*;
public class Snake {

    private Direction currentDirection;
    private Direction nextDirection;
    private ArrayList<Point> body = new ArrayList<>();

    public Snake(Point headPosition) {
        body.add(headPosition);
        body.add(new Point(headPosition.x - 1, headPosition.y));
        body.add(new Point(headPosition.x - 2, headPosition.y));
        this.currentDirection = Direction.RIGHT;
        this.nextDirection = Direction.RIGHT;
    }
    public void move() {
        this.currentDirection = this.nextDirection;
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
    public Direction getCurrentDirection() {
        return this.currentDirection;
    }
    public Direction getNextDirection() {
        return this.nextDirection;
    }
    public boolean setNextDirection(Direction inputDirection) {
        if ((inputDirection.ordinal() % 2) != (this.currentDirection.ordinal() % 2)) {
            this.nextDirection = inputDirection;
            return true;
        }
        else {
            return false;
        }
    }
    private Point getNewHead() {
        Point head = new Point(getHead());
        switch (currentDirection) {
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