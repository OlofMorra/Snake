package snake;

import java.awt.Point;

public class DoublyLinkedList {    
    public boolean isEmpty() {
        // TODO
        return false;
    }
    
    Point getFirst() {
        // TODO
        return null;
    }
    
    public Point getLast() {
        // TODO
        return null;
    }
    
    public void addFirst(Point p) {
        // TODO
    }
    
    public void addLast (Point p) {
        // TODO
    }
    
    public Point removeFirst() {
        // TODO
        return null;
    }
    
    public Point removeLast() {
        // TODO
        return null;
    }
    
    public String toString() {
        // TODO
        return "asldfgiasdf";
    }
}

/**
 * Node or body part of the snake. Has a reference to the next and
 * previous node, and is therefore a linked list.
 * @author Jan Heemstra
 *
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
     * Initialiser for Node. If it's an end node, pass null for nextArg. If 
     * it's a starting node, pass null for prevArg.
     * @param locationArg Location on the grid.
     * @param nextArg Next node in the list.
     * @param prevArg Previous node in the list.
     */
    Node(Point locationArg, Node nextArg, Node prevArg) {
        super(locationArg);
    }
}
