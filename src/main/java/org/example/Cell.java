package org.example;

public class Cell {
    private boolean isAlive;

    public Cell() {
        this.isAlive = false;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public String toString() {
        return this.isAlive ? "*" : "-";
    }
}
