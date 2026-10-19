package oop_lab1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import oop_lab1.exception.BudgetExceededException;
import oop_lab1.model.*;
import oop_lab1.util.DataLoader;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayroomServiceTest {
    private DataLoader mockLoader;
    private PlayroomService service;

    @BeforeEach
    void setup() { mockLoader = Mockito.mock(DataLoader.class); }

    @Test
    void testLoadSuccess() {
        when(mockLoader.loadToys("test.csv")).thenReturn(Arrays.asList(
                new Lego("L1", 100, 5, Size.SMALL, 10, "A")
        ));
        service = new PlayroomService(500.0, mockLoader);
        service.loadToysFromFile("test.csv");
        assertEquals(1, service.getToys().size());
    }

    @Test
    void testBudgetExceeded() {
        when(mockLoader.loadToys("test.csv")).thenReturn(Arrays.asList(
                new Lego("L1", 1000, 5, Size.SMALL, 10, "A")
        ));
        service = new PlayroomService(500.0, mockLoader);
        assertThrows(BudgetExceededException.class, () -> service.loadToysFromFile("test.csv"));
    }

    @Test
    void testSort() {
        when(mockLoader.loadToys("test.csv")).thenReturn(Arrays.asList(
                new Lego("L1", 500, 5, Size.SMALL, 10, "A"),
                new Lego("L2", 100, 5, Size.SMALL, 10, "A")
        ));
        service = new PlayroomService(1000.0, mockLoader);
        service.loadToysFromFile("test.csv");

        service.sortToys(Comparator.comparingDouble(Toy::getPrice));
        assertEquals("L2", service.getToys().get(0).getName());
    }

    @Test
    void testFind() {
        when(mockLoader.loadToys("test.csv")).thenReturn(Arrays.asList(
                new Lego("L1", 100, 5, Size.SMALL, 10, "A"),
                new Figurine("F1", 600, 5, Size.LARGE, false, "B")
        ));
        service = new PlayroomService(1000.0, mockLoader);
        service.loadToysFromFile("test.csv");

        assertEquals(1, service.findToys(t -> t.getPrice() > 300).size());
    }
}