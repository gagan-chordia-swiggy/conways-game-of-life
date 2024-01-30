package org.example;

public class Board {
    private final Cells cells;

    public Board(int rows, int columns, double seedPercent) {
        this.cells = new Cells(rows, columns, seedPercent);
    }
}
