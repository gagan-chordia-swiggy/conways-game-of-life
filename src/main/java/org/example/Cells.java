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

        this.seedCells(seedPercent);
    }

    public void displayCells() {
        for (int ii = 0; ii < this.rows; ii++) {
            for (int jj = 0; jj < this.columns; jj++) {
                System.out.println(" | " + this.cells[ii][jj].toString() + " | ");
            }
        }
    }

    public void evolve() {
        Cell[][] nextCells = new Cell[this.rows][this.columns];

        for (int ii = 0; ii < this.rows; ii++) {
            for (int jj = 0; jj < this.columns; jj++) {
                int liveNeighbours = countLiveNeighbours(ii, jj);
                nextCells[ii][jj] = new Cell(this.cells[ii][jj].isAlive());
                nextCells[ii][jj].determineState(liveNeighbours);
            }
        }

        this.cells = nextCells;
    }

    public boolean allCellsDead() {
        for (int ii = 0; ii < this.rows; ii++) {
            for (int jj = 0; jj < this.columns; jj++) {
                if (this.cells[ii][jj].isAlive()) {
                    return false;
                }
            }
        }

        return true;
    }

    private void seedCells(double seedPercent) {
        Random random = new Random();

        for (int ii = 0; ii < this.rows; ii++) {
            for (int jj = 0; jj < this.columns; jj++) {
                this.cells[ii][jj] = new Cell(random.nextDouble(0, 1) < seedPercent);
            }
        }
    }

    private int countLiveNeighbours(int row, int column) {
        int liveNeighbours = 0;

        int[] neighbourRows = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] neighbourColumns = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int ii = 0; ii < neighbourColumns.length; ii++) {
            int neighbourRow = row + neighbourRows[ii];
            int neighbourColumn = column + neighbourColumns[ii];

            if (neighbourRow >= 0 && neighbourRow < this.rows && neighbourColumn >= 0 && neighbourColumn < this.columns) {
                if (this.cells[neighbourRow][neighbourColumn].isAlive()) {
                    ++liveNeighbours;
                }
            }
        }

        return liveNeighbours;
    }
}
