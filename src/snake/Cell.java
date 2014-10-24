package snake;

import java.awt.Point;

public class Cell {
    enum state{
        EMPTY, SNAKE, SNAKEHEAD, SNAKETAIL
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
