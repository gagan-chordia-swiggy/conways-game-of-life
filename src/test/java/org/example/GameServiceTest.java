package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameServiceTest {
    @Test
    @DisplayName("Test if game is created")
    void testGameIsNotNull() {
        // Arrange & Act
        Board board = new Board(1,1);
        GameService gameService = new GameService(board);

        // Assert
        assertNotNull(gameService);
    }

    @Test
    @DisplayName("Test if game with no board throws exception")
    void testGameWithNoBoardThrowsException() {
        // Assert
        assertThrows(NullPointerException.class, () -> new GameService(null));
    }
}
