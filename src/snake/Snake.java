package snake;

import java.awt.Point;

public class Snake extends SnakeList {
    private Point nextNode = new Point(0, 0);
    private int food;
    
    enum Direction{
        NORTH, 
        EAST, 
        SOUTH, 
        WEST
    }
    
    static Direction direction;
    
    public Snake() {
        Point startP = new Point(10, 10);
        Node newNode = new Node(startP, null, null);
        first = newNode;
        last = newNode;
        
        food = 300;
    }

    /**
     * Set where the snake goes next
     * @param x x-location of next point
     * @param y y-location of next point
     */
    public void setDirection(int x, int y) {
        nextNode.setLocation(new Point(x, y));
    }

    /**
     * @return Point which the snake will enter next.
     */
    public Point getDirection() {
        return nextNode;
    }

    /**
     * Moves the snake another unit.
     */
    public void step() {
        // TODO Do the next step of the snake.
        resetNextNode();
        if(food > 0) {
            food--;
        } else {
            removeLast();
        }
        addFirst(getDirection());
    }
    
    /**
     * Resets the nextNode variable to the correct direction.
     */
    void resetNextNode() {
        // TODO
    }
    
    /**
     * @return The next place the snake will go.
     */
    Point computeNext() {
        Point returnP = first.location;
        switch (direction) {
        case NORTH: returnP.y += 1;
        case EAST: returnP.x += 1;
        case SOUTH: returnP.y -= 1;
        case WEST: returnP.x -= 1;
        }
        return returnP;
    }
}