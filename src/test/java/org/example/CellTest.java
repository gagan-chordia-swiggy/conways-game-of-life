package org.example;

import org.example.exceptions.InvalidLocationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class CellTest {
    @Test
    @DisplayName("Test a cell is created")
    void testCellIsCreated() {
        // Arrange & Act
        Cell cell = new Cell(false);

        // Assert
        assertNotNull(cell);
    }

    @Test
    @DisplayName("Test that cell is dead")
    void testCellIsNotAlive() {
        // Arrange
        Cell cell = new Cell(false);

        // Act
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
    }

    @Test
    @DisplayName("Test that cell is alive")
    void testCellIsAlive() {
        // Arrange
        Cell cell = new Cell(true);

        // Act
        cell.alive(true);
        boolean actual = cell.isAlive();

        // Assert
        assertTrue(actual);
    }
}
