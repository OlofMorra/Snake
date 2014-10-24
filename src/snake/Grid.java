package snake;

import static java.awt.Color.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JPanel;

public class Grid extends JPanel implements KeyListener, ActionListener {
    private Snake snake;
    
    Cell[][] gridValues = new Cell[15][];

    
    public Grid() {
        // TODO make the grid have values and stuff.
        // intialize 
        // ^ I kid you not, it was spelled like this in the starter files...

        // Install key listener and obtain focus
        addKeyListener(this);
        setFocusable(true);
        requestFocus();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        // draw each grid element
    }
    
    /** 
     * Let the snake make a step
     */
    void step() {
        //...  
        snake.step();
        //...
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
        //...
    }
}