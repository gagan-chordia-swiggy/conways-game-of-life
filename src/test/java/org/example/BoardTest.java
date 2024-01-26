package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testBoardWithNegative10RowsThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(-10, 12));
    }

    @Test
    @DisplayName("Test board with 0 columns throws error")
    void testBoardWithZeroColumnsThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(1, 0));
    }

    @Test
    @DisplayName("Test board with -1 column throws error")
    void testBoardWithNegative1ColumnThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(4, -1));
    }

    @Test
    @DisplayName("Test board with -10 columns throws error")
    void testBoardWithNegative10ColumnsThrowsException() {
        // Assert
        assertThrows(IllegalArgumentException.class, () -> new Board(10, -10));
    }

    @Test
    @DisplayName("Test seeding random population of cells")
    void testSeedRandomPopulation() {
        // Arrange
        Board board = new Board(10, 10);
        double seedPercentage = 0.7;
        int alive = 0;
        int totalCells = board.cells().length * board.cells()[0].length;

        // Act
        board.seedRandomPopulation(seedPercentage);

        for (int ii = 0; ii < board.cells().length; ii++) {
            for (int jj = 0; jj < board.cells()[0].length; jj++) {
                if(board.cells()[ii][jj].isAlive()) {
                    ++alive;
                }
            }
        }

        double actualPercentage = (double) alive / totalCells;

        assertTrue(Math.abs(actualPercentage - seedPercentage) < 0.1);
    }

    @Test
    @DisplayName("Seeding cells with zero seed percent")
    void testSeedingCellsWithZeroSeedPercentRateShouldThrowException() {
        // Arrange
        Board board = new Board(12, 12);
        double seedPercentage = 0.0;

        // Assert
        assertThrows(RuntimeException.class, () -> board.seedRandomPopulation(seedPercentage));
    }
}
