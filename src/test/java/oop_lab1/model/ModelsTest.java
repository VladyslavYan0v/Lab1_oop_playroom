package oop_lab1.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelsTest {
    @Test
    void testLegoCreation() {
        Lego lego = new Lego("TestLego", 100.0, 5, Size.SMALL, 50, "City");
        assertEquals("TestLego", lego.getName());
        assertEquals(100.0, lego.getPrice());
        assertEquals(50, lego.getNumberOfParts());
    }

    @Test
    void testFigurineCreation() {
        Figurine fig = new Figurine("TestFig", 200.0, 10, Size.LARGE, true, "Marvel");
        assertTrue(fig.isLimitedEdition());
        assertEquals("Marvel", fig.getFranchise());
    }

    @Test
    void testScaleModelCreation() {
        ScaleModel model = new ScaleModel("Tank", 950.0, 12, Size.MEDIUM, true, "1:35");
        assertEquals("1:35", model.getScale());
        assertTrue(model.isLimitedEdition());
    }
}