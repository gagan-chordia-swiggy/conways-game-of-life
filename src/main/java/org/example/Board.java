package org.example;

public class Board {
    private final int rows;
    private final int columns;
    private Cell[][] cells;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new IllegalArgumentException("Invalid board size");
        }
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];
    }

    public void display() {
        for (int ii = 0; ii < rows; ii++) {
            for (int jj = 0; jj < columns; jj++) {
                System.out.print(" | " + cells[ii][jj].toString() + " | ");
            }
            System.out.println();
        }
    }

    public Cell[][] cells() {
        return this.cells;
    }
}
