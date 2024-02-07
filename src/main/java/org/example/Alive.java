package org.example;

import org.example.exceptions.InvalidLiveNeighboursException;

public class Alive implements Cell {
    @Override
    public Cell determineState(int liveNeighbours) {
        if (liveNeighbours < 0) {
            throw new InvalidLiveNeighboursException();
        }

        return (liveNeighbours == 2 || liveNeighbours == 3) ? new Alive() : new Dead();
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public boolean equals(Cell other) {
        return other instanceof Alive;
    }
}
