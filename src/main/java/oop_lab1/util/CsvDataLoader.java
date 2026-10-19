package oop_lab1.util;

import oop_lab1.model.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataLoader implements DataLoader {
    @Override
    public List<Toy> loadToys(String filePath) {
        List<Toy> toys = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) continue;
                toys.add(createToy(line.split(";")));
            }
        } catch (IOException e) {
            System.err.println("Помилка файлу: " + e.getMessage());
        }
        return toys;
    }

    public Toy createToy(String[] data) {
        String category = data[0].trim().toLowerCase();
        String name = data[1].trim();
        double price = Double.parseDouble(data[2].trim());
        int minAge = Integer.parseInt(data[3].trim());
        Size size = Size.valueOf(data[4].trim().toUpperCase());

        if (category.equals("lego")) {
            return new Lego(name, price, minAge, size, Integer.parseInt(data[5].trim()), data[6].trim());
        } else if (category.equals("figurine")) {
            return new Figurine(name, price, minAge, size, Boolean.parseBoolean(data[5].trim()), data[6].trim());
        } else if (category.equals("scalemodel")) {
            return new ScaleModel(name, price, minAge, size, Boolean.parseBoolean(data[5].trim()), data[6].trim());
        }
        throw new IllegalArgumentException("Невідома категорія: " + category);
    }
}