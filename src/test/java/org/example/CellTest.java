package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    @DisplayName("Test alive cell state with 4 alive neighbours changes to dead state")
    void testAliveCellWith4AliveNeighborsChangesToDeadStateAndReturnsFalse() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Cell cell = new Cell();
        Field aliveField = Cell.class.getDeclaredField("isAlive");
        aliveField.setAccessible(true);
        aliveField.set(cell, true);

        // Act
        cell.decideState(4);
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
    }

    @Test
    @DisplayName("Test alive cell state with 10 alive neighbours changes to dead state")
    void testAliveCellWith10AliveNeighborsChangesToDeadStateAndReturnsFalse() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Cell cell = new Cell();
        Field aliveField = Cell.class.getDeclaredField("isAlive");
        aliveField.setAccessible(true);
        aliveField.set(cell, true);

        // Act
        cell.decideState(10);
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
    }

    @Test
    @DisplayName("Test when a cell decision to change with negative number of alive cells should throw error")
    void testForNegativeAliveCellsForChangingStateOfCurrentCellThrowsException() {
        // Arrange
        Cell cell = new Cell();

        // Assert
        assertThrows(RuntimeException.class, () -> cell.decideState(-1));
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

    @Test
    @DisplayName("Test alive cell should return *")
    void testAliveCellValueIsStar() throws NoSuchFieldException, IllegalAccessException {
        // Arrange
        Cell cell = new Cell();
        Field aliveField = Cell.class.getDeclaredField("isAlive");
        aliveField.setAccessible(true);
        aliveField.set(cell, true);

        // Act
        String actual = cell.toString();

        // Assert
        assertEquals("*", actual);
    }

    @Test
    @DisplayName("Test Create a live cell")
    void testCreateLiveCell() {
        // Arrange
        Cell cell = Cell.createAliveCell();

        // Act
        boolean actual = cell.isAlive();

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Test create live cell doesn't affect other cells")
    void testCreateLiveCellDoesNotAffectOtherCells() {
        // Arrange
        Cell cell1 = new Cell();
        Cell cell2 = new Cell();
        Cell cell3 = Cell.createAliveCell();

        // Act

        // Assert
        assertFalse(cell1.isAlive());
        assertFalse(cell2.isAlive());
        assertTrue(cell3.isAlive());
    }
}
