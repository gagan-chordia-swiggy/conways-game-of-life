package org.example;

import org.example.exceptions.InvalidDimensionException;
import org.example.exceptions.InvalidSeedingException;

import java.util.Random;

public class Cells {
    private final int rows;
    private final int columns;
    private Cell[][] cells;

    public Cells(int rows, int columns, double seedPercent) {
        if (rows < 1 || columns < 1) {
            throw new InvalidDimensionException();
        }

        if (seedPercent < 0.01) {
            throw new InvalidSeedingException();
        }

        this.rows = rows;
        this.columns = columns;
        this.cells = new Cell[rows][columns];

        seedCells(seedPercent);
    }

    public Cell[][] cells() {
        return this.cells;
    }

    public void updateCells(Cell[][] cells) {
        this.cells = cells;
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
