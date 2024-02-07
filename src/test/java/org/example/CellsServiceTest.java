package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
                cellMatrix[ii][jj] = new Dead();
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
                cellMatrix[ii][jj] = new Alive();
            }
        }

        // Act
        when(cells.cells()).thenReturn(cellMatrix);
        boolean actual = service.allCellsDead();

        // Assert
        assertFalse(actual);
    }

    @Test
    void testCellsEvolveBasedOnTheirNeighbours() {
        // Arrange
        Cells cells = new Cells(4, 4, 0.4);
        CellsService service = new CellsService(cells);

        // Act
        Cell[][] beforeEvolving = cells.cells();
        service.evolve();
        Cell[][] afterEvolving = cells.cells();

        // Assert
        assertNotEquals(beforeEvolving, afterEvolving);
    }

    @Test
    void testCellsAreNotInSameStateWhenInitialized() {
        // Arrange
        Cells cells = new Cells(5, 5, 0.3);
        CellsService service = new CellsService(cells);

        // Act
        boolean actual = service.inSameState();

        // Assert
        assertFalse(actual);
    }

    @Test
    void testCellsAreInSameStateAfter2RoundsOfEvolving() {
        // Arrange
        Cell[][] cellMatrix = new Cell[][]{
                {new Alive(), new Alive()},
                {new Alive(), new Alive()}
        };
        Cells cells = mock(Cells.class);
        CellsService service = new CellsService(cells);

        // Act
        when(cells.cells()).thenReturn(cellMatrix);
        service.evolve();
        service.evolve();
        boolean actual = service.inSameState();

        // Assert
        assertTrue(actual);
    }

    @Test
    void testCellsDoNotRemainInSameStateAfter2RoundsOfEvolving() {
        // Arrange
        Cell[][] cellMatrix = new Cell[][]{
                {new Dead(), new Alive(), new Dead()},
                {new Alive(), new Dead(), new Dead()}
        };
        Cells cells = mock(Cells.class);
        CellsService service = new CellsService(cells);

        // Act
        when(cells.cells()).thenReturn(cellMatrix);
        service.evolve();
        service.evolve();
        boolean actual = service.inSameState();

        // Assert
        assertFalse(actual);
    }
}
