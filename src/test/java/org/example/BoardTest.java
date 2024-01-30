package org.example;

import org.example.exceptions.InvalidDimensionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void testBoardIsCreated() {
        // Arrange & Act
        Board board = new Board(12, 2);

        // Assert
        assertNotNull(board);
    }

    @Test
    void testBoardWithNegativeRowsThrowsException() {
        // Assert
        assertThrows(InvalidDimensionException.class, () -> new Board(-1, 2));
    }

    @Test
    void testBoardWithZeroRowsThrowsException() {
        // Assert
        assertThrows(InvalidDimensionException.class, () -> new Board(0, 2));
    }

    @Test
    void testBoardWithNegativeColumnsThrowsException() {
        // Assert
        assertThrows(InvalidDimensionException.class, () -> new Board(1, -2));
    }

    @Test
    void testBoardWithZeroColumnsThrowsException() {
        // Assert
        assertThrows(InvalidDimensionException.class, () -> new Board(9, 0));
    }
}
