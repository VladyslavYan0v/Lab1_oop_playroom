package oop_lab1.model;

public abstract class CollectibleToy extends Toy {
    private final boolean isLimitedEdition;

    public CollectibleToy(String name, double price, int minAge, Size size, boolean isLimitedEdition) {
        super(name, price, minAge, size);
        this.isLimitedEdition = isLimitedEdition;
    }

    public boolean isLimitedEdition() { return isLimitedEdition; }
}