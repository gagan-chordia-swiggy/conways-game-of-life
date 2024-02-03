package org.example;

import java.util.Random;

public class Board {
    private final CellsService cellsService;

    public Board(int rows, int columns) {
        double seedPercent = new Random().nextDouble(0.1, 1);
        Cells cells = new Cells(rows, columns, seedPercent);
        this.cellsService = new CellsService(cells);
    }

    public void displayBoard() {
        this.cellsService.displayCells();
    }

    public void evolve() {
        this.cellsService.evolve();
    }

    public boolean checkAllCellsDead() {
        return this.cellsService.allCellsDead();
    }
}
