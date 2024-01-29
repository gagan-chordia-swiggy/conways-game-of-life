package org.example;

import org.example.exceptions.InvalidLocationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LocationTest {
    @Test
    void testLocationIsCreated() {
        // Arrange, Act
        Location location = new Location(12, 3);

        // Assert
        assertNotNull(location);
    }

    @Test
    void testLocationRowIsNegativeThrowsException() {
        // Assert
        assertThrows(InvalidLocationException.class, () -> new Location(-1, 7));
    }

    @Test
    void testLocationColumnIsNegativeThrowsException() {
        // assert
        assertThrows(InvalidLocationException.class, () -> new Location(12, -7));
    }
}
