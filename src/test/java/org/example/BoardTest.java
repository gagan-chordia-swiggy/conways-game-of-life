package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    void testBoardIsCreated() {
        // Arrange & Act
        Board board = new Board(12, 2, 0.9);

        // Assert
        assertNotNull(board);
    }
}
