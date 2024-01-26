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
        if (aliveNeighbours < 0) {
            throw new RuntimeException("Negative alive cells");
        }
        if (!this.isAlive()) {
            if (aliveNeighbours == 3) {
                this.isAlive = true;
            }
        } else {
            if (aliveNeighbours < 2 || aliveNeighbours > 3) {
                this.isAlive = false;
            }
        }
    }

    @Override
    public String toString() {
        return this.isAlive ? "*" : "-";
    }
}
