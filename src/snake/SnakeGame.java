package snake;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.Timer;

public class SnakeGame extends JFrame {
    DoublyLinkedList snake = new DoublyLinkedList();

    SnakeGame() {
        Grid grid = new Grid();

        // Add grid to frame
        this.add(grid, BorderLayout.CENTER);

        this.setTitle("Snake");
        this.setSize(1280, 720); // Potato resolution
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Start snake
        Timer timer = new Timer(100, grid);
        timer.start();
    }

    public static void main(String[] a) {
        new SnakeGame();
    }
}