package oop_lab1.util;

import oop_lab1.model.Toy;
import java.util.List;

public interface DataLoader {
    List<Toy> loadToys(String filePath);
}