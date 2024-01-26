package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoardTest {
    @Test
    @DisplayName("Test if board is being created")
    void testBoardIsNotNull() {
        // Arrange & Act
        Board board = new Board(10, 12);

        // Assert
        assertNotNull(board);
    }
}
