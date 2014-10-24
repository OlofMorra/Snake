package snake;

import java.awt.Color;
import java.awt.Point;

public class SnakeList {
    Node first; // Head of the snake
    Node last; // Tail of the snake
    
    /**
     * Checks if the list is empty
     * @return Whether the list is empty or not
     */
    public boolean isEmpty() {
        if (first == null || last == null) {
            return true;
        }
        
        return false;
    }
    
    /**
     * @return Location of the head.
     */
    Point getFirst() {
        return first.location;
    }
    
    /**
     * @return Location of the tail.
     */
    public Point getLast() {
        return last.location;
    }
    
    /**
     * Extends the head
     * @param p Location where to extend towards.
     */
    public void addFirst(Point p) {
        if (isEmpty()) {
            return;
        }
        
        first.extend(p, false);
        first = first.next;
    }
    
    /**
     * Extends the tail
     * @param p Location where to extend towards.
     */
    public void addLast (Point p) {
        if (isEmpty()) {
            return;
        }
        last.extend(p, true);
        last = last.prev;
    }
    
    /**
     * Removes head.
     * @return The location of the point that's removed.
     */
    public Point removeFirst() {
        if (first == null) {
            return null;
        }
        first.pop();
        first = first.next;
        
        if (first == null) {
            last = null;
            return null;
        }
        
        return first.location;
    }
    
    /**
     * Removes tail.
     * @return Location of removed element.
     */
    public Point removeLast() {
        if (last == null) {
            return null;
        }
        
        Point returnLoc = last.location;
        SnakeGame.setColor(returnLoc, Grid.backGr);
        
        DrawCell lastCell = 
                SnakeGame.grid.gridValues[last.location.x][last.location.y];
        lastCell.cell.setBackground(Grid.backGr);
        last.pop();
        last = last.next;
        
        if (last == null) {
            first = null;
            return null;
        }
        
        return returnLoc;
    }
    
    /**
     * Will output simple description for your mom to understand.
     * @return Said description
     */
    public String toString() {
        // TODO Override Object.String
        return "";
    }
    
}

/**
 * Node or body part of the snake. Has a reference to the next and
 * previous node, and is therefore a linked list.
 * @author Jan Heemstra
 * @author Olof Morra
 */
class Node extends Cell{    
    /**
     * Next node. Is null when this is an end node.
     */
    Node next;
    
    /**
     * Previous node. Is null when this is a starting node.
     */
    Node prev;
    
    /**
     * Initializer for Node. If it's an end node, pass null for nextArg. If 
     * it's a starting node, pass null for prevArg.
     * @param locationArg Location on the grid.
     * @param nextArg Next node in the list.
     * @param prevArg Previous node in the list.
     */
    Node(Point locationArg, Node nextArg, Node prevArg) {
        super(locationArg);
        SnakeGame.setColor(locationArg, Grid.snakeColor);
    }
    
    /**
     * Will delete the node from the linked list. Only possible if it's the
     * first or last element!
     * @return True if succeeded. False if it's neither the first nor the last
     * element.
     */
    boolean pop() {
        if (next == null && prev != null) {
            prev.next = null;
        } else if (prev == null && next != null) {
            next.prev = null;
        } else {
            // We're neither the last or first element: failure!
            return false;
        }
        
        return true;
    }
    
    /**
     * Will add a node to one of the ends of 
     * @param locationArg Where to add the next point.
     * @param isNext Whether or not to extend to the last.
     * @return True if it succeeded. False if it was not on one of the ends of
     * the linked list.
     */
    boolean extend(Point locationArg, boolean isNext) {
        // Prevent referencer errors.
        Point newP = new Point(locationArg.x, locationArg.y);
                
        if (wallCollision(newP) || snakeCollision(newP)) {
            System.exit(0); // Or something similar
        }
        
        if (!isNext && next == null) {
            // We're in the head
            next = new Node(newP, null, this);
        } else if (isNext && prev == null) {
            // We're in the tail
            prev = new Node(newP, this, null);
        } else {
            // We're neither the head nor the tail, so we can't extend anywhere...
            return false;
        }
               
        return true;
    }
    
    /**
     * @return Whether p is outside the grid
     */
    boolean wallCollision(Point p) {
    	
    	if(p.getX() < 0 || p.getY() < 0 || p.getX() >= 40 || p.getY() >= 40) {
    		return true;
    	}
        return false;
    }
    
    /**
     * @return Whether the snake will hit himself
     */
    boolean snakeCollision(Point p) {
    	double x = p.getX();
    	double y = p.getY();
    	
    	
    	if(SnakeGame.isGreen(p)) {
    		return true;
    	}
    	
    	return false;
    }
    
}
