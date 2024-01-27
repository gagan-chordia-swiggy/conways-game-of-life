package org.example;

import java.util.Random;

public class Board {
    private final int rows;
    private final int columns;
    private Cell[][] cells;

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

    public boolean allCellsDead() {
        for (int ii = 0; ii < this.rows; ii++) {
            for (int jj = 0; jj < this.columns; jj++) {
                if (this.cells[ii][jj].isAlive()) {
                    return false;
                }
            }
        }
        System.out.println("All cells dead");
        return true;
    }

    public void evolve() {
        Cell[][] newCells = new Cell[this.rows][this.columns];

        for (int ii = 0; ii < this.rows; ii++) {
            for (int jj = 0; jj < this.columns; jj++) {
                int liveNeighbours = this.countLiveNeighbours(ii, jj);

                newCells[ii][jj] = new Cell();
                newCells[ii][jj].decideState(liveNeighbours);
            }
        }

        this.cells = newCells;
    }

    private void seedLiveCells(double seedPercent) {
        if (seedPercent < 0) {
            throw new RuntimeException("Seed percent cannot be less than zero");
        }

        Random random = new Random();

        for (int ii = 0; ii < this.rows; ii++) {
            for (int jj = 0; jj < this.columns; jj++) {
                if (random.nextDouble(0, 1) < seedPercent) {
                    this.cells[ii][jj] = Cell.createAliveCell();
                } else {
                    this.cells[ii][jj] = new Cell();
                }
            }
        }
    }

    private int countLiveNeighbours(int row, int column) {
        int liveNeighbours = 0;

        for (int ii = -1; ii <= 1; ii++) {
            for (int jj = -1; jj <= 1; jj++) {
                int neighborRow = row + ii;
                int neighborColumn = column + jj;

                // Skipping the cell itself
                if (ii == 0 && jj == 0) {
                    continue;
                }

                if (neighborRow >= 0 & neighborRow < this.rows && neighborColumn >= 0 && neighborColumn < this.columns) {
                    if (this.cells[neighborRow][neighborColumn].isAlive()) {
                        ++liveNeighbours;
                    }
                }
            }
        }

        return liveNeighbours;
    }
}
