package snake;

import static java.awt.Color.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;

import snake.Cell.state;

public class Grid extends JPanel implements KeyListener, ActionListener {
    private Snake snake;
    
    Cell[][] gridValues;

    Point size = new Point(10, 10);
    
    /**
     * Initialises the grid, and sets the size to Grid.size
     */
    public Grid() {
        // TODO make the grid have values.
        setSize(size);
        
        snake = new Snake();
        
        // Install key listener and obtain focus
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
        this.setBackground(BLACK);
    }
    
    /**
     * Will set the size of the grid, and fill it up.
     * @param sizeArg New size of the grid.
     */
    public void setSize(Point sizeArg) {
        gridValues = new Cell[sizeArg.x][sizeArg.y];
        for (int i = 0; i < sizeArg.x; i++) {
            for (int j = 0; j < sizeArg.y; j++) {
                gridValues[i][j] = new Cell(new Point(i, j), state.EMPTY);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Make grid elements display.
        super.paintComponent(g); 
        // draw each grid element
    }
    
    /** 
     * Let the snake make a step
     */
    void step() {
        // Snake makes a step.
        snake.step();
    }   

    @Override public void keyTyped(KeyEvent e) {    }
    @Override public void keyReleased(KeyEvent e) {    }

    @Override
    public void keyPressed(KeyEvent e) {
        // inspect e.getKeycode()
        // arrow key codes: KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT     
    }

    @Override
    public void actionPerformed(ActionEvent e) {  // called on Timer event
        step();
    }
}

class DrawCell extends Cell {
    /**
     * 
     */
    JPanel cell = new JPanel();
    
    public DrawCell(Point locationArg, state cellStateArg) {
        super(locationArg, cellStateArg);
    }
}