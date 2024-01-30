package org.example;

import java.util.Random;

public class Cells {
    private final int rows;
    private final int columns;
    private final Cell[][] cells;

    public Cells(int rows, int columns, double seedPercent) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];

        this.seedCells(seedPercent);
    }

    private void seedCells(double seedPercent) {
        Random random = new Random();

        for (int ii = 0; ii < this.rows; ii++) {
            for (int jj = 0; jj < this.columns; jj++) {
                this.cells[ii][jj] = new Cell(random.nextDouble(0, 1) < seedPercent);
            }
        }
    }
}
