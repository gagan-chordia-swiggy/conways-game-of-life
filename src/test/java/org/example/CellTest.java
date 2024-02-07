package org.example;

import org.example.exceptions.InvalidLiveNeighboursException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void testLiveCellWithLessThan2NeighboursDies() {
        // Arrange
        Cell cell = new Alive();

        // Act
        Cell actual = cell.determineState(1);

        // Assert
        assertInstanceOf(Dead.class, actual);
    }

    @Test
    void testLiveCellWithMoreThan3NeighboursDies() {
        // Arrange
        Cell cell = new Alive();

        // Act
        Cell actual = cell.determineState(5);

        // Assert
        assertInstanceOf(Dead.class, actual);
    }

    @Test
    void testLiveCellWithExactly2NeighbourLives() {
        // Arrange
        Cell cell = new Alive();

        // Act
        Cell actual = cell.determineState(2);

        // Assert
        assertInstanceOf(Alive.class, actual);
    }

    @Test
    void testLiveCellWithExactly3NeighbourLives() {
        // Arrange
        Cell cell = new Alive();

        // Act
        Cell actual = cell.determineState(3);

        // Assert
        assertInstanceOf(Alive.class, actual);
    }

    @Test
    void testDeadCellWithExactly3NeighborsComesToLife() {
        // Arrange
        Cell cell = new Dead();

        // Act
        Cell actual = cell.determineState(3);

        // Assert
        assertInstanceOf(Alive.class, actual);
    }

    @Test
    void testDeadCellWithLessThan3NeighboursDies() {
        // Arrange
        Cell cell = new Dead();

        // Act
        Cell actual = cell.determineState(2);

        // Assert
        assertInstanceOf(Dead.class, actual);
    }

    @Test
    void testDeadCellWithMoreThan3NeighboursDies() {
        // Arrange
        Cell cell = new Dead();

        // Act
        Cell actual = cell.determineState(4);

        // Assert
        assertInstanceOf(Dead.class, actual);
    }

    @Test
    void testAliveCellNegativeLiveNeighboursThrowException() {
        // Arrange
        Cell cell = new Alive();

        // Act

        // Assert
        assertThrows(InvalidLiveNeighboursException.class, () -> cell.determineState(-9));
    }

    @Test
    void testDeadCellNegativeLiveNeighboursThrowException() {
        // Arrange
        Cell cell = new Dead();

        // Act

        // Assert
        assertThrows(InvalidLiveNeighboursException.class, () -> cell.determineState(-9));
    }

    @Test
    void testDeadCellHasValueHyphen() {
        // Arrange
        Cell cell = new Dead();

        // Act
        String actual = cell.toString();

        // Assert
        assertEquals("-", actual);
    }

    @Test
    void testLiveCellHasValueStar() {
        // Arrange
        Cell cell = new Alive();

        // Act
        String actual = cell.toString();

        // Assert
        assertEquals("*", actual);
    }

    @Test
    void test2DeadCellsAreEqual() {
        // Arrange
        Cell cell1 = new Dead();
        Cell cell2 = new Dead();

        // Act
        boolean actual1 = cell2.equals(cell1);
        boolean actual2 = cell1.equals(cell2);

        // Assert
        assertTrue(actual1);
        assertTrue(actual2);
    }

    @Test
    void test2AliveCellsAreEqual() {
        // Arrange
        Cell cell1 = new Alive();
        Cell cell2 = new Alive();

        // Act
        boolean actual1 = cell2.equals(cell1);
        boolean actual2 = cell1.equals(cell2);

        // Assert
        assertTrue(actual1);
        assertTrue(actual2);
    }

    @Test
    void testAliveAndDeadCellsAreNotEqual() {
        // Arrange
        Cell cell1 = new Alive();
        Cell cell2 = new Dead();

        // Act
        boolean actual1 = cell2.equals(cell1);
        boolean actual2 = cell1.equals(cell2);

        // Assert
        assertFalse(actual1);
        assertFalse(actual2);
    }
}
