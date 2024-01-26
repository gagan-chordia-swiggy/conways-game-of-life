package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {
    @Test
    @DisplayName("Test a cell is created")
    void testCellIsCreated() {
        // Arrange & Act
        Cell cell = new Cell();

        // Assert
        assertNotNull(cell);
    }

    @Test
    @DisplayName("Test give life to cell")
    void testGiveLifeToCellReturnTrue() {
        // Arrange
        Cell cell = new Cell();

        // Act
        cell.setAlive(true);

        // Assert
        assertTrue(cell.isAlive());
    }

    @Test
    @DisplayName("Test check cell is dead")
    void testCellIsDead() {
        // Arrange
        Cell cell = new Cell();

        // Act

        // Assert
        assertFalse(cell.isAlive());
    }
}
