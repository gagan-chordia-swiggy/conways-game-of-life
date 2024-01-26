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
    @DisplayName("Test check cell is dead")
    void testCellIsDead() {
        // Arrange
        Cell cell = new Cell();

        // Act

        // Assert
        assertFalse(cell.isAlive());
    }

    @Test
    @DisplayName("Test cell state has modified to alive with exactly 3 neighbours around")
    void testTestCellHasChangedToAliveWith3NeighborsAroundAndReturnsTrue() {
        // Arrange
        Cell cell = new Cell();

        // Act
        cell.decideState(3);
        boolean actual = cell.isAlive();

        // Assert
        assertTrue(actual);
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
