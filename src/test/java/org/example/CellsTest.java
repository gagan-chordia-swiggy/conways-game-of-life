package org.example;

import org.example.exceptions.InvalidDimensionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CellsTest {
    @Test
    void testCellsAreCreated() {
        // Arrange, Act
        Cells cells = new Cells(12, 12, 0.2);

        // Assert
        assertNotNull(cells);
    }

    @Test
    void testZeroCellRowThrowsException() {
        // Assert
        assertThrows(InvalidDimensionException.class, () -> new Cells(0, 12, 0.9));
    }

    @Test
    void testNegativeCellRowsThrowsException() {
        // Assert
        assertThrows(InvalidDimensionException.class, () -> new Cells(-4, 12, 0.9));
    }

    @Test
    void testZeroCellColumnThrowsException() {
        // Assert
        assertThrows(InvalidDimensionException.class, () -> new Cells(10, 0, 0.9));
    }

    @Test
    void testNegativeCellColumnsThrowsException() {
        // Assert
        assertThrows(InvalidDimensionException.class, () -> new Cells(4, -12, 0.9));
    }
}
