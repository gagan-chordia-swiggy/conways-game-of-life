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

    @Test
    void testDeadCellIsCreated() {
        // Arrange
        Cell cell = new Cell(false);

        // Act
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
    }

    @Test
    void testLiveCellIsCreated() {
        // Arrange
        Cell cell = new Cell(true);

        // Act
        boolean actual = cell.isAlive();

        // Assert
        assertTrue(actual);
    }
}
