package snake;

import java.awt.Point;

public class Snake extends DoublyLinkedList {
    private Point nextNode;
    private int food;
    
    public Snake() {
        // TODO initialise with an s!
    }

    public void setDirection(int x, int y) {
        nextNode.setLocation(new Point(x, y));
    }

    public Point getDirection() {
        return nextNode;
    }

    public void step() {
        //System.out.println("alsdkfh");
        // TODO Do the next step of the snake.
    }

    // ...
}