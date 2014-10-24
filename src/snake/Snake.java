package snake;

import java.awt.Point;

/**
 * 
 * @author Jan Heemstra
 * @author Olof Morra
 */
public class Snake extends SnakeList {
    private Point nextNode = new Point(0, 0);
    private int food;
    
    enum Direction{
        NORTH, 
        EAST, 
        SOUTH, 
        WEST
    }
    
    static Direction direction = Direction.NORTH;
    
    public Snake() {
        Point startP = new Point(20, 20);
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
        nextNode = computeNext();
    }
    
    /**
     * @return The next place the snake will go.
     */
    Point computeNext() {
        Point returnP = first.location;
        switch (direction) {
        case NORTH: returnP.x -= 1;
        break;
        case EAST: returnP.y += 1;
        break;
        case SOUTH: returnP.x += 1;
        break;
        case WEST: returnP.y -= 1;
        }
        return returnP;
    }
}