package oop_lab1.util;

import oop_lab1.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CsvDataLoaderTest {
    private final CsvDataLoader loader = new CsvDataLoader();

    @Test
    void testParseLego() {
        String[] data = {"lego", "Ship", "500", "8", "LARGE", "300", "Space"};
        Toy toy = loader.createToy(data);
        assertTrue(toy instanceof Lego);
    }

    @Test
    void testParseScaleModel() {
        String[] data = {"scalemodel", "Diorama", "300", "12", "SMALL", "false", "1:35"};
        Toy toy = loader.createToy(data);
        assertTrue(toy instanceof ScaleModel);
        assertEquals("1:35", ((ScaleModel) toy).getScale());
    }

    @Test
    void testParseUnknownThrowsException() {
        String[] data = {"car", "BMW", "100", "3", "SMALL", "Sport", "Red"};
        assertThrows(IllegalArgumentException.class, () -> loader.createToy(data));
    }
}