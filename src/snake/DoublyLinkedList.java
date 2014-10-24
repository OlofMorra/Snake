package snake;

import java.awt.Point;

public class DoublyLinkedList {
    Node first;
    Node last;
    
    public boolean isEmpty() {
        if (first == null && last == null) {
            return true;
        }
        
        return false;
    }
    
    Point getFirst() {
        return first.location;
    }
    
    public Point getLast() {
        return last.location;
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
        return "I have no idea what behavior you're trying to suggest.";
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
    
    /**
     * Will delete the node from the linked list. Only possible if it's the
     * first or last element!
     * @return True if succeeded. False if it's neither the first nor the last
     * element.
     */
    boolean pop() {
        if (next == null) {
            prev.next = null;
        } else if (prev == null) {
            next.prev = null;
        } else {
            // We're neither the last or first element: failure!
            return false;
        }
        
        return true;
    }
}
