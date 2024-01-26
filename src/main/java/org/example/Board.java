package org.example;

public class Board {
    private final int rows;
    private final int columns;
    private Cell[][] cells;

    public Board(int rows, int columns) {
        if (rows < 1) {
            throw new IllegalArgumentException("Invalid board size");
        }
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];
    }
}
