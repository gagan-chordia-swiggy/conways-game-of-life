package org.example;

import org.example.exceptions.InvalidLiveNeighboursException;

public class Cell {
    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void determineState(int liveNeighbours) {
        if (liveNeighbours < 0) {
            throw new InvalidLiveNeighboursException();
        }

        if (isAlive) {
            isAlive = liveNeighbours == 2 || liveNeighbours == 3;
        } else {
            isAlive = liveNeighbours == 3;
        }
    }

    @Override
    public String toString() {
        return this.isAlive ? "*" : "-";
    }
}
