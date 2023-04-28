package game;

import java.util.ArrayList;
import java.awt.Point;
public class Snake {
    private static enum Direction {
        UP, DOWN, LEFT, RIGHT;
    }
    private Direction direction;
    private ArrayList<Point> body = new ArrayList<>();

    public Snake(Point headPosition) {
        body.add(headPosition);
        body.add(new Point(headPosition.x - 1, headPosition.y));
        body.add(new Point(headPosition.x - 2, headPosition.y));
        System.out.println(getBody().toString());
        direction = Direction.RIGHT;
    }
    public void move() {
        Point head = new Point(getHead()); // MUTABILITY!!
        System.out.println(head.x);
        switch (direction) {
            case UP -> head.y--;
            case DOWN -> head.y++;
            case LEFT -> head.x--;
            case RIGHT -> head.x++;
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
        this.direction = direction;
    }
    public Point getHead() {
        return body.get(0);
    }
    public ArrayList<Point> getBody() {
        return body;
    }

}
