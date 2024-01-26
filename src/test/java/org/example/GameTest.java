package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    @Test
    @DisplayName("Test if game is created")
    void testGameIsNotNull() {
        // Arrange & Act
        Board board = new Board(1,1);
        Game game = new Game(board);

        // Assert
        assertNotNull(game);
    }

    @Test
    @DisplayName("Test if game with no board throws exception")
    void testGameWithNoBoardThrowsException() {
        // Assert
        assertThrows(NullPointerException.class, () -> new Game(null));
    }
}
