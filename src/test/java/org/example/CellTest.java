package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

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

    // Using reflections to change cell state to alive
    @Test
    @DisplayName("Test alive cell state with 1 alive neighbour changes to dead state")
    void testAliveCellStateWith1AliveNeighbourChangesToDeadAndReturnFalse() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Cell cell = new Cell();
        Field aliveField = Cell.class.getDeclaredField("isAlive");
        aliveField.setAccessible(true);
        aliveField.set(cell, true);

        // Act
        cell.decideState(1);
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
    }

    @Test
    @DisplayName("Test alive cell state with 0 alive neighbours changes to dead state")
    void testAliveCellWithZeroAliveNeighborsChangesToDeadStateAndReturnsFalse() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Cell cell = new Cell();
        Field aliveField = Cell.class.getDeclaredField("isAlive");
        aliveField.setAccessible(true);
        aliveField.set(cell, true);

        // Act
        cell.decideState(0);
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
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
