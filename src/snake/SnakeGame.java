package snake;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SnakeGame extends JFrame {
    DoublyLinkedList snake = new DoublyLinkedList();
    
    SnakeGame() {
        Grid grid = new Grid();
        
        // add grid to frame
        this.add(grid,BorderLayout.CENTER);
        
        this.setTitle("Snake");
        this.setSize( 400, 300 ); // or whatever size you need
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // start snake
        Timer timer = new Timer(100, grid);
        timer.start();
    }
    
    public static void main(String[] a) {
        new SnakeGame();
    }
}