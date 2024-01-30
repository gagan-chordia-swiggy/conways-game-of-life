package org.example;

import java.util.Random;

public class Board {
    private final Cells cells;

    public Board(int rows, int columns) {
        double seedPercent = new Random().nextDouble(0.1, 1);
        this.cells = new Cells(rows, columns, seedPercent);
    }

    public void displayBoard() {
        this.cells.displayCells();
    }

    public void evolve() {
        this.cells.evolve();
    }
}
