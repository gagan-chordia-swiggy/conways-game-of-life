package org.example;

import org.example.exceptions.InvalidLiveNeighboursException;

public interface Cell {
    Cell determineState(int liveNeighbours);
}
