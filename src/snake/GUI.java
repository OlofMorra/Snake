package snake;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI implements ActionListener {
    JFrame frame = new JFrame("Snake");
    Dimension windowRes = new Dimension(1280, 720);
    
    int gridSizeX = 20;
    int gridSizeY = 20;
    
    JPanel grid = new JPanel();
    
    JButton button = new JButton("asdf");
    
    /**
     * Will open the window, and initiate the program.
     */
    public GUI() {
        // TODO Generate grid
        frame.setSize(windowRes);
        
        button.setSize(new Dimension(100, 100));
        
        frame.getContentPane().add(grid, BorderLayout.NORTH);
        
        frame.setVisible(true);
    }
    
    /**
     * Program starts here.
     * @param args
     */
    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
    }
}
