package org.example;

public class Cell {
    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void determineState(int liveNeighbours) {
        if (isAlive) {
            isAlive = liveNeighbours == 2 || liveNeighbours == 3;
        }
    }
}
