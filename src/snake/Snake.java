package snake;

import java.awt.Point;

/**
 * Snake class. This will color the cells in the grid according to where the snake is.
 * 
 * @author Jan Heemstra
 * @author Olof Morra
 */
public class Snake extends SnakeList {
    private Point nextNode = new Point(0, 0); // Next point the snake will "eat"
    private int food; // How much it still has to grow
    
    /**
     * Enumeration for denoting directions on the screen.
     * @author Jan Heemstra
     * @author Olof Morra
     */
    enum Direction{
        NORTH, 
        EAST, 
        SOUTH, 
        WEST
    }
    
    private Direction direction = Direction.NORTH;
    private Direction newDirection = direction;
    
    /**
     * Initializer for Snake.
     */
    public Snake() {
        Point startP = new Point(20, 20);
        Node newNode = new Node(startP, null, null);
        first = newNode;
        last = newNode;
        
        food = 20;
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
        direction = newDirection;
        
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
    

    
    /**
     * Sets the new direction if it's valid.=
     * @param d New direction
     * @return If the direction is valid
     */
    boolean setDirection (Direction d) {
        if(validDirection(d)) {
            newDirection = d;
            return true;
        }
        return false;
    }
    
    /**
     * Returns if a new direction doesn't conflict with the old one.
     * @param d The new direction to check conflict against the snake's own direction.
     * @return Whether the new direction is a valid one
     */
    boolean validDirection(Direction d) {
        switch (d) {
        case NORTH:
        case SOUTH:
            if (direction == Direction.SOUTH || direction == Direction.NORTH) {
                return false;
            }
            break;
        case WEST:
        case EAST:
            if (direction == Direction.WEST || direction == Direction.EAST) {
                return false;
            }
        }
        return true;
    }
}