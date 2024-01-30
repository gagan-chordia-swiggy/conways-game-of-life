package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void testCellIsCreated() {
        // Arrange & Act
        Cell cell = new Cell(false);

        // Assert
        assertNotNull(cell);
    }
}
