package ch.thediggers.streaming.models;

import ch.thediggers.streaming.util.Config;

/**
 * Represents a slice of streaming on the grid.
 *
 * @author Thomsch
 */
public class Slice {
    private final int rowStart;
    private final int colStart;
    private final int rowEnd;
    private final int colEnd;

    public Slice(int rowStart, int colStart, int numRows, int numCols) {
        this.rowStart = rowStart;
        this.colStart = colStart;
        this.rowEnd = rowStart + numRows - 1;
        this.colEnd = colStart + numCols - 1;
    }

    @Override
    public String toString() {
        return rowStart + Config.SEPARATOR + colStart + Config.SEPARATOR + rowEnd + Config.SEPARATOR + colEnd;
    }
}
