package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CellsTest {
    @Test
    void testCellsAreCreated() {
        // Arrange, Act
        Cells cells = new Cells(12, 12, 0.2);

        // Assert
        assertNotNull(cells);
    }
}
