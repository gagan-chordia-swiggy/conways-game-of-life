package org.example;

import org.example.exceptions.InvalidLocationException;

public class Cell {
    private boolean isAlive;

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void alive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public String toString() {
        return this.isAlive ? "*" : "-";
    }
}
