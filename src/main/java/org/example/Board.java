package org.example;

public class Board {
    private final int rows;
    private final int columns;
    private Cell[][] cells;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];
    }
}
