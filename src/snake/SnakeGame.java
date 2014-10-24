package snake;

import java.awt.BorderLayout;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.Timer;

public class SnakeGame extends JFrame {
    //SnakeList snake = new SnakeList();

    static Grid grid = new Grid();
    
    /**
     * Will change the color of the specified point.
     * @param p Point to change the color of
     * @param c Color to change to
     */
    static void setColor(Point p, Color c) {
        if (grid == null) {
            return; // TODO make this better
        }
        
        DrawCell cellToChange = grid.gridValues[p.x][p.y];
        cellToChange.cell.setBackground(c);
    }
    
    static boolean isGreen(Point p) {
    	DrawCell cellToCheck = grid.gridValues[p.x][p.y];
    	
    	if(cellToCheck.cell.getBackground().equals(grid.Snake)) {
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * Initializes the game.
     */
    SnakeGame() {
        // Add grid to frame
        add(grid, BorderLayout.CENTER);

        // Setup for the window.
        setTitle("Snake");
        setSize(800, 800); // Potato resolution
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        // Start snake
        Timer timer = new Timer(100, grid);
        timer.start();
    }

    public static void main(String[] a) {
        new SnakeGame();
    }
}