package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CellsServiceTest {
    @Test
    void testAllCellsAreDead() {
        // Arrange
        Cell[][] cellMatrix = new Cell[3][3];
        Cells cells = mock(Cells.class);
        CellsService service = new CellsService(cells);
        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                cellMatrix[ii][jj] = new Cell(false);
            }
        }

        // Act
        when(cells.cells()).thenReturn(cellMatrix);
        boolean actual = service.allCellsDead();

        // Assert
        assertTrue(actual);
    }

    @Test
    void testAtLeastOneCellIsAlive() {
        // Arrange
        Cell[][] cellMatrix = new Cell[3][3];
        Cells cells = mock(Cells.class);
        CellsService service = new CellsService(cells);
        for (int ii = 0; ii < 3; ii++) {
            for (int jj = 0; jj < 3; jj++) {
                cellMatrix[ii][jj] = new Cell(true);
            }
        }

        when(cells.cells()).thenReturn(cellMatrix);
        boolean actual = service.allCellsDead();

        // Assert
        assertFalse(actual);
    }
}
