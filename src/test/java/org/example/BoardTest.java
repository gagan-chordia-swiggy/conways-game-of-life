package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {
    @Test
    @DisplayName("Test if board is being created")
    void testBoardIsNotNull() {
        // Arrange & Act
        Board board = new Board(10, 12);

        // Assert
        assertNotNull(board);
    }

    @Test
    @DisplayName("Test board with 0 rows throws error")
    void testBoardWithZeroRowsThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(0, 12));
    }

    @Test
    @DisplayName("Test board with -1 rows throws error")
    void testBoardWithNegative1RowThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(-1, 12));
    }

    @Test
    @DisplayName("Test board with -10 rows throws error")
    void testBoardWithNegative10RowThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(-10, 12));
    }

    @Test
    @DisplayName("Test board with 0 columns throws error")
    void testBoardWithZeroColumnsThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(1, 0));
    }
}
