package snake;

import java.awt.Point;

/**
 * Snake class. This will color the cells in the grid according to where the snake is.
 * TODO Collision detection.
 * 
 * @author Jan Heemstra
 * @author Olof Morra
 */
public class Snake extends SnakeList {
    private Point nextNode = new Point(0, 0);
    private int food; // How much it still has to grow
    
    /**
     * Enumeration for denoting directions on the screen.
     * @author jan
     */
    enum Direction{
        NORTH, 
        EAST, 
        SOUTH, 
        WEST
    }
    
    Direction direction = Direction.NORTH;
    
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
        if (checkCollision()) {
            System.exit(0); // Or something similar
        }
        
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
     * TODO finish this function
     * @return Whether p is inside another object.
     */
    boolean checkCollision(Point p) {
        return false;
    }
    /**
     * TODO
     * @return Whether the new direction is a valid one
     */
    boolean validDir() {
        return false;
    }
}