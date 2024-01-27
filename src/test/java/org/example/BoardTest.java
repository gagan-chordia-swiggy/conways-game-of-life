package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {
    @Test
    @DisplayName("Test if board is being created")
    void testBoardIsNotNull() {
        // Arrange & Act
        Board board = new Board(10, 12, 0.7);

        // Assert
        assertNotNull(board);
    }

    @Test
    @DisplayName("Test board with 0 rows throws error")
    void testBoardWithZeroRowsThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(0, 12, 0.7));
    }

    @Test
    @DisplayName("Test board with -1 rows throws error")
    void testBoardWithNegative1RowThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(-1, 12, 0.7));
    }

    @Test
    @DisplayName("Test board with -10 rows throws error")
    void testBoardWithNegative10RowsThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(-10, 12, 0.7));
    }

    @Test
    @DisplayName("Test board with 0 columns throws error")
    void testBoardWithZeroColumnsThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(1, 0, 0.6));
    }

    @Test
    @DisplayName("Test board with -1 column throws error")
    void testBoardWithNegative1ColumnThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(4, -1, 0.5));
    }

    @Test
    @DisplayName("Test board with -10 columns throws error")
    void testBoardWithNegative10ColumnsThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(10, -10, 0.9));
    }

    @Test
    @DisplayName("Test all cells are dead when seed percent is zero")
    void testAllCellsAreDeadWhenSeedPercentIsZeroAndReturnTrue() {
        // Arrange
        Board board = new Board(12, 8, 0.0);

        // Act
        boolean actual = board.allCellsDead();

        // Assert
        assertTrue(actual);
    }

    @Test
    @DisplayName("Test at least 1 cell is alive when seed percent is greater than zero")
    void testAtLeast1CellIsAliveWhenSeedPercentIsGreaterThanZero() {
        // Arrange
        Board board = new Board(12, 8, 0.1);

        // Act
        boolean actual = board.allCellsDead();

        // Assert
        assertFalse(actual);
    }

    @Test
    @DisplayName("Test when seed percent is less than zero should throw exception")
    void testWhenSeedPercentLessThanZeroThrowsException() {
        // Assert
        assertThrows(RuntimeException.class, () -> new Board(12, 45, -2));
    }
}
