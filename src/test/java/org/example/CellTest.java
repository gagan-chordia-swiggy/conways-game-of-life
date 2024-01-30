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

    @Test
    void testLiveCellWithLessThan2NeighboursDies() {
        // Arrange
        Cell cell = new Cell(true);

        // Act
        cell.determineState(1);
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
    }

    @Test
    void testLiveCellWithMoreThan3NeighboursDies() {
        // Arrange
        Cell cell = new Cell(true);

        // Act
        cell.determineState(5);
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
    }

    @Test
    void testLiveCellWithExactly2NeighbourLives() {
        // Arrange
        Cell cell = new Cell(true);

        // Act
        cell.determineState(2);
        boolean actual = cell.isAlive();

        // Assert
        assertTrue(actual);
    }

    @Test
    void testLiveCellWithExactly3NeighbourLives() {
        // Arrange
        Cell cell = new Cell(true);

        // Act
        cell.determineState(3);
        boolean actual = cell.isAlive();

        // Assert
        assertTrue(actual);
    }

    @Test
    void testDeadCellWithExactly3NeighborsComesToLife() {
        // Arrange
        Cell cell = new Cell(false);

        // Act
        cell.determineState(3);
        boolean actual = cell.isAlive();

        // Assert
        assertTrue(actual);
    }

    @Test
    void testDeadCellWithLessThan2NeighboursDies() {
        // Arrange
        Cell cell = new Cell(false);

        // Act
        cell.determineState(1);
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
    }

    @Test
    void testDeadCellWithMoreThan3NeighboursDies() {
        // Arrange
        Cell cell = new Cell(false);

        // Act
        cell.determineState(5);
        boolean actual = cell.isAlive();

        // Assert
        assertFalse(actual);
    }
}
