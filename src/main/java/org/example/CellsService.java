package org.example;

public class CellsService {
    private final Cells cells;
    private Cell[][] previousState = null;
    private Cell[][] currentState = null;

    public CellsService(Cells cells) {
        this.cells = cells;
    }

    public void displayCells() {
        Cell[][] cellMatrix = this.cells.cells();

        for (Cell[] matrix : cellMatrix) {
            for (Cell cell : matrix) {
                System.out.print(" | " + cell + " | ");
            }
            System.out.println();
        }
    }

    public boolean allCellsDead() {
        Cell[][] cellMatrix = this.cells.cells();

        for (Cell[] matrix : cellMatrix) {
            for (Cell cell : matrix) {
                if (cell instanceof Alive) {
                    return false;
                }
            }
        }

        System.out.println("All cells are dead");
        return true;
    }

    public boolean inSameState() {
        if (this.previousState == null) {
            return false;
        }

        int rows = this.currentState.length;
        int columns = this.currentState[0].length;

        for (int ii = 0; ii < rows; ii++) {
            for (int jj = 0; jj < columns; jj++) {
                if (!this.currentState[ii][jj].equals(this.previousState[ii][jj])) {
                    this.previousState = this.currentState;
                    return false;
                }
            }
        }
        System.out.println("Cells are in same state");
        return true;
    }

    public void evolve() {
        Cell[][] cellMatrix = this.cells.cells();
        int rows = cellMatrix.length;
        int columns = cellMatrix[0].length;
        this.currentState = new Cell[rows][columns];

        for (int ii = 0; ii < rows; ii++) {
            for (int jj = 0; jj < columns; jj++) {
                int liveNeighbours = countLiveNeighbours(ii, jj);
                currentState[ii][jj] = cellMatrix[ii][jj].determineState(liveNeighbours);
            }
        }

        this.previousState = cellMatrix;
        this.cells.updateCells(currentState);
    }

    private int countLiveNeighbours(int row, int column) {
        int liveNeighbours = 0;

        Cell[][] cellMatrix = this.cells.cells();
        int rows = cellMatrix.length;
        int columns = cellMatrix[0].length;

        int[] neighbourRows = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] neighbourColumns = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int ii = 0; ii < neighbourColumns.length; ii++) {
            int neighbourRow = row + neighbourRows[ii];
            int neighbourColumn = column + neighbourColumns[ii];

            if (neighbourRow >= 0 && neighbourRow < rows && neighbourColumn >= 0 && neighbourColumn < columns) {
                if (cellMatrix[neighbourRow][neighbourColumn] instanceof Alive) {
                    ++liveNeighbours;
                }
            }
        }

        return liveNeighbours;
    }
}
