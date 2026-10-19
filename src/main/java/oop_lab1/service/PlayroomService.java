package oop_lab1.service;

import oop_lab1.exception.BudgetExceededException;
import oop_lab1.model.Toy;
import oop_lab1.util.DataLoader;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PlayroomService {
    private final List<Toy> toys = new ArrayList<>();
    private final double budget;
    private final DataLoader dataLoader;
    private double currentSpend = 0.0;

    public PlayroomService(double budget, DataLoader dataLoader) {
        this.budget = budget;
        this.dataLoader = dataLoader;
    }

    public void loadToysFromFile(String filePath) {
        List<Toy> loadedToys = dataLoader.loadToys(filePath);
        for (Toy toy : loadedToys) {
            if (currentSpend + toy.getPrice() > budget) {
                throw new BudgetExceededException("Бюджет перевищено. Іграшка: " + toy.getName());
            }
            toys.add(toy);
            currentSpend += toy.getPrice();
        }
    }

    public void sortToys(Comparator<Toy> comparator) {
        toys.sort(comparator);
    }

    public List<Toy> findToys(Predicate<Toy> condition) {
        return toys.stream().filter(condition).collect(Collectors.toList());
    }

    public List<Toy> getToys() { return toys; }
    public double getCurrentSpend() { return currentSpend; }
}