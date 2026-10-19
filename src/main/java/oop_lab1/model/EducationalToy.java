package oop_lab1.model;

public abstract class EducationalToy extends Toy {
    private final int numberOfParts;

    public EducationalToy(String name, double price, int minAge, Size size, int numberOfParts) {
        super(name, price, minAge, size);
        this.numberOfParts = numberOfParts;
    }

    public int getNumberOfParts() { return numberOfParts; }
}