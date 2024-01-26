package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    @DisplayName("Test check cell is dead")
    void testCellIsDead() {
        // Arrange
        Cell cell = new Cell();

        // Act

        // Assert
        assertFalse(cell.isAlive());
    }

    @Test
    @DisplayName("Test dead cell should return -")
    void testDeadCellValueIsHyphen() {
        // Arrange
        Cell cell = new Cell();

        // Act
        String actual = cell.toString();

        // Assert
        assertEquals("-", actual);
    }
}
