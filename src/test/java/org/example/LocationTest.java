package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LocationTest {
    @Test
    void testLocationIsCreated() {
        // Arrange, Act
        Location location = new Location(12, 3);

        // Assert
        assertNotNull(location);
    }
}
