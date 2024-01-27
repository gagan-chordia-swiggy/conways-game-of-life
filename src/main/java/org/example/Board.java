package org.example;

import java.util.Random;

public class Board {
    private final int rows;
    private final int columns;
    private final Cell[][] cells;

    public Board(int rows, int columns, double seedPercent) {
        if (rows < 1 || columns < 1) {
            throw new IllegalArgumentException("Invalid board size");
        }
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];

        seedLiveCells(seedPercent);
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

    private void seedLiveCells(double seedPercent) {
        Random random = new Random();

        for (int ii = 0; ii < this.rows; ii++) {
            for (int jj = 0; jj < this.columns; jj++) {
                if (random.nextDouble(0, 1) < seedPercent) {
                    cells[ii][jj] = Cell.createAliveCell();
                } else {
                    cells[ii][jj] = new Cell();
                }
            }
        }
    }
}
