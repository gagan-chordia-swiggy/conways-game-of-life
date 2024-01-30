package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        boolean actual = cell.isAlive();

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Test alive cell has value of *")
    void testAliveCellReturnsAStar() {
        // Arrange
        Cell cell = new Cell(true);

        // Act
        String actual = cell.toString();

        // Assert
        assertEquals("*", actual);
    }

    @Test
    @DisplayName("Test dead cell has value of -")
    void testDeadCellReturnsAHyphen() {
        // Arrange
        Cell cell = new Cell(false);

        // Act
        String actual = cell.toString();

        // Assert
        assertEquals("-", actual);
    }
}
