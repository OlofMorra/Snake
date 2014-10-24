package snake;

import java.awt.Color;
import java.awt.Point;

public class Cell {
    enum state{
        EMPTY, SNAKE, SNAKEHEAD, SNAKETAIL
    }
    
    /**
     * Default colors for the grid cells
     */
    static Color backGr = new Color(50, 50, 50);
    static Color snakeColor = new Color(0, 200, 0);
    
    static public Color stateColor(state cellState) {
        switch (cellState) {
        case EMPTY:
            return backGr;
        case SNAKE:
            return snakeColor;
        }
        return null;
    }
    
    Point location;
    
    state cellState;

    /**
     * Creates a cell at a certain location.
     * @param locationArg
     */
    public Cell(Point locationArg) {
        location = locationArg;
        cellState = state.EMPTY;
    }
    
    public Cell(Point locationArg, state cellStateArg) {
        location = locationArg;
        cellState = cellStateArg;
    }
}
