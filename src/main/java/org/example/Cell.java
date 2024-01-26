package org.example;

public class Cell {
    private boolean isAlive;

    public Cell() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void decideState(int aliveNeighbours) {
        if (!this.isAlive()) {
            if (aliveNeighbours == 3) {
                this.isAlive = true;
            }
        } else {
            if (aliveNeighbours < 2) {
                this.isAlive = false;
            }
        }
    }

    @Override
    public String toString() {
        return this.isAlive ? "*" : "-";
    }
}
