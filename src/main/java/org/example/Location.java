package org.example;

import org.example.exceptions.InvalidLocationException;

public record Location(int row, int column) {
    public Location {
        if (row < 0 || column < 0) {
            throw new InvalidLocationException();
        }
    }
}
